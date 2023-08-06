package com.example.resto_menu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resto_menu.adapter.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemData> menuList = createDummyData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MenuAdapter menuAdapter = new MenuAdapter(menuList, this);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<ItemData> createDummyData() {
        List<ItemData> data = new ArrayList<>();

        data.add(new ItemData(1, "Bakso", 10000, R.drawable.bakso, "Bakso adalah makanan yang terbuat dari daging sapi yang dihaluskan dan dibentuk bulat-bulat."));
        data.add(new ItemData(2, "Mie Ayam", 12000, R.drawable.mie_ayam, "Mie ayam adalah makanan yang terbuat dari mie dan daging ayam."));
        data.add(new ItemData(3, "Nasi Goreng", 15000, R.drawable.nasi_goreng, "Nasi goreng adalah makanan yang terbuat dari nasi yang digoreng."));
        data.add(new ItemData(4, "Soto Ayam", 12000, R.drawable.soto_ayam, "Soto ayam adalah makanan yang terbuat dari kuah kaldu ayam."));
        data.add(new ItemData(5, "Nasi Uduk", 10000, R.drawable.nasi_uduk, "Nasi uduk adalah makanan yang terbuat dari nasi yang dimasak dengan santan."));
        data.add(new ItemData(6, "Nasi Kuning", 10000, R.drawable.nasi_kuning, "Nasi kuning adalah makanan yang terbuat dari nasi yang dimasak dengan kunyit."));
        data.add(new ItemData(7, "Nasi Kucing", 5000, R.drawable.nasi_kucing, "Nasi kucing adalah makanan yang terbuat dari nasi yang dibungkus daun pisang."));
        data.add(new ItemData(8, "Nasi Pecel", 10000, R.drawable.nasi_pecel, "Nasi pecel adalah makanan yang terbuat dari nasi yang disiram dengan bumbu pecel."));
        data.add(new ItemData(9, "Sate Ayam", 15000, R.drawable.sate_ayam, "Sate ayam adalah makanan yang terbuat dari daging ayam yang ditusuk dengan tusuk sate."));

        // Add more items as needed

        return data;
    }

}