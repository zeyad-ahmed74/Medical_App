package com.zeyad.medicalapp.viewmodel;


import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zeyad.medicalapp.data.model.RegistrationResponse;
import com.zeyad.medicalapp.data.model.request.RegisterRequest;
import com.zeyad.medicalapp.data.source.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {


    private MutableLiveData<RegistrationResponse> _registerLiveData = new MutableLiveData<>();
    public LiveData<RegistrationResponse> registerLiveData = _registerLiveData;

    private MutableLiveData<String> _message = new MutableLiveData<>();
    public LiveData<String> message = _message;

    public void CreateNewUser(RegisterRequest registerRequest) {

        RetrofitClient.getWebService()
                .CreateUser(registerRequest).enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {

                        if(response.isSuccessful()){
                            _registerLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                        _message.setValue(t.getLocalizedMessage());

                    }
                });
    }
}
