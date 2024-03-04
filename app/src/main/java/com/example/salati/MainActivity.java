package com.example.salati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<PrayerItem> prayerItems = new ArrayList<>();
        prayerItems.add(new PrayerItem("SOBH", R.drawable.ruku, 2));
        prayerItems.add(new PrayerItem("DHOR", R.drawable.prayer, 4));
        prayerItems.add(new PrayerItem("ASR", R.drawable.salah, 4));
        prayerItems.add(new PrayerItem("MAGHRB", R.drawable.sujud, 3));
        prayerItems.add(new PrayerItem("ISHA", R.drawable.islamic, 4));

        recyclerView.setAdapter(new PrayerAdapter(this, prayerItems));
    }
}