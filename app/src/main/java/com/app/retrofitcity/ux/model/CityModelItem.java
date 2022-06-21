package com.app.retrofitcity.ux.model;

import com.google.gson.annotations.SerializedName;

public class CityModelItem{

	@SerializedName("name")
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

}