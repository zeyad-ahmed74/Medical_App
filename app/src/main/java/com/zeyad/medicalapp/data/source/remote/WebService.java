package com.zeyad.medicalapp.data.source.remote;

import com.zeyad.medicalapp.data.model.EmployeesResponse;
import com.zeyad.medicalapp.data.model.LoginResponse;
import com.zeyad.medicalapp.data.model.RegistrationResponse;
import com.zeyad.medicalapp.data.model.request.LoginRequest;
import com.zeyad.medicalapp.data.model.request.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {

     @POST("login")
     Call<LoginResponse> CheckLogin(@Body LoginRequest loginRequest);

     @POST("register")
     Call<RegistrationResponse> CreateUser(@Body RegisterRequest registerRequest);


     @GET("doctors")
     Call<EmployeesResponse> getEmployees(@Query("type") String type , @Header("Authorization") String token);

}
