package com.example.resto_menu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resto_menu.DetailActivity;
import com.example.resto_menu.ItemData;
import com.example.resto_menu.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<ItemData> dataList;
    private Context context;

    public MenuAdapter(List<ItemData> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, int position) {
        ItemData data = dataList.get(position);
        holder.textView.setText(data.getName());
        holder.imageView.setImageResource(data.getImageResourceId());
        holder.priceView.setText(String.valueOf(data.getPrice()));
        holder.descriptionView.setText(data.getDescription());

        // Set click listener
        holder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", data.getId());
                intent.putExtra("name", data.getName());
                intent.putExtra("price", data.getPrice());
                intent.putExtra("image", data.getImageResourceId());
                intent.putExtra("description", data.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView priceView;
        TextView descriptionView;
        Button detailButton;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            priceView = itemView.findViewById(R.id.price_view);
            descriptionView = itemView.findViewById(R.id.description_view);
            detailButton = itemView.findViewById(R.id.pesan_button);
        }
    }
}
