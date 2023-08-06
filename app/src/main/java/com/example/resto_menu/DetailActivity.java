package com.example.resto_menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    // Initial quantity
    private int quantity = 1;
    private double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.detail_image_view);
        TextView nameText = findViewById(R.id.detail_name_text);
        TextView priceText = findViewById(R.id.detail_price_text);
        TextView quantityText = findViewById(R.id.quantity_text);
        Button plusButton = findViewById(R.id.plus_button);
        Button minusButton = findViewById(R.id.minus_button);
        TextView descriptionText = findViewById(R.id.detail_description_text);
        Button processButton = findViewById(R.id.process_order_button);

        // Get data from intent
        imageView.setImageResource(getIntent().getIntExtra("image", 0));
        nameText.setText(getIntent().getStringExtra("name"));
        priceText.setText(String.valueOf(getIntent().getDoubleExtra("price", 0)));
        descriptionText.setText(getIntent().getStringExtra("description"));
        quantityText.setText(String.valueOf(quantity));
        price = getIntent().getDoubleExtra("price", 0);

        updateTotalPrice();
        minusButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityText.setText(String.valueOf(quantity));
                updateTotalPrice();
            }
        });

        plusButton.setOnClickListener(v -> {
            quantity++;
            quantityText.setText(String.valueOf(quantity));
            updateTotalPrice();
        });

        processButton.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, OrderActivity.class);
            intent.putExtra("id", getIntent().getIntExtra("id", 0));
            intent.putExtra("name", getIntent().getStringExtra("name"));
            intent.putExtra("price", price);
            intent.putExtra("quantity", quantity);
            intent.putExtra("total", price * quantity);
            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    private void updateTotalPrice() {
        TextView totalText = findViewById(R.id.total_price_text);
        double totalPrice = quantity * price;
        totalText.setText("Total Beli: " + totalPrice);
    }
}