package com.app.retrofitcity.ux.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
	private static RetrofitClient instance = null;
	private final ApiInterface apiInterface;

	private RetrofitClient() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		apiInterface = retrofit.create(ApiInterface.class);
	}

	public static synchronized RetrofitClient getInstance() {
		if (instance == null) {
			instance = new RetrofitClient();
		}
		return instance;
	}
	public ApiInterface getApiInterface(){
		return apiInterface;
	}
}
