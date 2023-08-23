package com.zeyad.medicalapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("address")
	private String address;

	@SerializedName("gender")
	private String gender;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("type")
	private String type;

	@SerializedName("token_type")
	private String tokenType;

	@SerializedName("access_token")
	private String accessToken;

	@SerializedName("specialist")
	private String specialist;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	public String getBirthday(){
		return birthday;
	}

	public String getAddress(){
		return address;
	}

	public String getGender(){
		return gender;
	}

	public String getMobile(){
		return mobile;
	}

	public boolean isVerified(){
		return verified;
	}

	public String getLastName(){
		return lastName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getType(){
		return type;
	}

	public String getTokenType(){
		return tokenType;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public String getSpecialist(){
		return specialist;
	}

	public int getId(){
		return id;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getEmail(){
		return email;
	}

	public String getStatus(){
		return status;
	}
}