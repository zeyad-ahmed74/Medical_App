package com.zeyad.medicalapp.data.model;

import com.google.gson.annotations.SerializedName;

public class EmployeeResponse {

	@SerializedName("id")
	private int id;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("type")
	private String type;

	@SerializedName("first_name")
	private String firstName;

	public int getId(){
		return id;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getType(){
		return type;
	}

	public String getFirstName(){
		return firstName;
	}
}