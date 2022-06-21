package com.app.retrofitcity.ux.api;

import com.app.retrofitcity.ux.model.CityModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
	String BASE_URL="https://dl.android-studio.ir/";
	@GET("files/city.json")
	Call<List<CityModelItem>> getCityNames();
}
