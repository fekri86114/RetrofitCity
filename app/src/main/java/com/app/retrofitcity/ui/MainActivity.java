package com.app.retrofitcity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.retrofitcity.databinding.ActivityMainBinding;
import com.app.retrofitcity.ui.adapter.CityNameAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CityNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new CityNameAdapter();
        binding.recyclerCityName.setHasFixedSize(true);
        binding.recyclerCityName.setAdapter(adapter);

    }
}