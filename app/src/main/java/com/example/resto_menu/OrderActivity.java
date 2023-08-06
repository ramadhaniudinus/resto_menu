package com.example.resto_menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView nameText = findViewById(R.id.item_text);
        TextView priceText = findViewById(R.id.price_text);
        TextView quantityText = findViewById(R.id.quantity_value);
        TextView totalPriceText = findViewById(R.id.total_price_text);
        Button backToMenuButton = findViewById(R.id.back_to_menu_button);

        // Get data from intent
        nameText.setText(getIntent().getStringExtra("name"));
        priceText.setText(String.valueOf(getIntent().getDoubleExtra("price", 0)));
        quantityText.setText(String.valueOf(getIntent().getIntExtra("quantity", 0)));
        totalPriceText.setText(String.valueOf(getIntent().getDoubleExtra("price", 0) * getIntent().getIntExtra("quantity", 0)));

        backToMenuButton.setOnClickListener(v -> {
            Intent intent = new Intent(OrderActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}