package com.zeyad.medicalapp.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zeyad.medicalapp.data.model.LoginResponse;
import com.zeyad.medicalapp.data.model.request.LoginRequest;
import com.zeyad.medicalapp.data.source.remote.RetrofitClient;
import com.zeyad.medicalapp.databinding.FragmentLoginBinding;
import com.zeyad.medicalapp.ui.LoginArgs;
import com.zeyad.medicalapp.ui.hr.HRActivity;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {


    private MutableLiveData<LoginResponse> _loginLiveData = new MutableLiveData<>();
    public LiveData<LoginResponse> loginLiveData = _loginLiveData;


    private MutableLiveData<String> _message = new MutableLiveData<>();
    public LiveData<String> message = _message;


    public void checkLogin(LoginRequest loginRequest) {

        RetrofitClient.getWebService().CheckLogin(loginRequest)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                        if (response.isSuccessful()) {
                                _loginLiveData.setValue(response.body());
                        }

                    }
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        _message.setValue(t.getLocalizedMessage());
                    }
                });

    }
}
