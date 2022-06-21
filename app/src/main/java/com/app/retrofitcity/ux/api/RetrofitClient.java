package com.app.retrofitcity.ux.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
	private static RetrofitClient instance = null;
	private final ApiInterface apiInterface;

	public OkHttpClient getClient() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(logging)
				.build();

		return client;
	}

	private RetrofitClient() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(getClient())
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
