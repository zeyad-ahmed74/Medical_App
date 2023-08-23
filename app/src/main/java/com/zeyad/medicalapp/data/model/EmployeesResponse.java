package com.zeyad.medicalapp.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EmployeesResponse {

	@SerializedName("data")
	private List<EmployeeResponse> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public List<EmployeeResponse> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public int getStatus(){
		return status;
	}
}