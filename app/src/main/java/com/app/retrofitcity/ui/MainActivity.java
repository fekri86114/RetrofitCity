package com.app.retrofitcity.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.retrofitcity.databinding.ActivityMainBinding;
import com.app.retrofitcity.ui.adapter.CityNameAdapter;
import com.app.retrofitcity.ux.api.RetrofitClient;
import com.app.retrofitcity.ux.model.CityModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private ActivityMainBinding binding;
	private CityNameAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		confirmRecyclerView();

		getCityNames();

	}

	private void confirmRecyclerView() {
		binding.recyclerCityName.setHasFixedSize(true);
		binding.recyclerCityName.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

	}

	private void getCityNames() {
		Call<List<CityModelItem>> listCall = RetrofitClient.getInstance().getApiInterface().getCityNames();
		listCall.enqueue(new Callback<List<CityModelItem>>() {
			@Override
			public void onResponse(Call<List<CityModelItem>> call, Response<List<CityModelItem>> response) {
				List<CityModelItem> cityModelItemList = response.body();
				adapter = new CityNameAdapter(cityModelItemList);
				binding.recyclerCityName.setAdapter(adapter);
			}

			@Override
			public void onFailure(Call<List<CityModelItem>> call, Throwable t) {
				Log.e(TAG, "onFailure: " + t.getMessage());
			}
		});
	}

}