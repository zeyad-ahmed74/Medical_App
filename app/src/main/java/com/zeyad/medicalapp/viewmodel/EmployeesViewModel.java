package com.zeyad.medicalapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zeyad.medicalapp.data.model.EmployeesResponse;
import com.zeyad.medicalapp.data.model.LoginResponse;
import com.zeyad.medicalapp.data.source.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeesViewModel extends ViewModel {

    private MutableLiveData<EmployeesResponse> _employeesLiveData = new MutableLiveData<>();
    public LiveData<EmployeesResponse> employeesLiveData = _employeesLiveData;


    private MutableLiveData<String> _message = new MutableLiveData<>();
    public LiveData<String> message = _message;

    public void getEmployees(String type , String token) {

        Log.d("eeee","token :"+token);
        RetrofitClient.getWebService()
                .getEmployees(type,"Bearer "+token).enqueue(new Callback<EmployeesResponse>() {
                    @Override
                    public void onResponse(Call<EmployeesResponse> call, Response<EmployeesResponse> response) {

                        if(response.isSuccessful()){
                            _employeesLiveData.setValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<EmployeesResponse> call, Throwable t) {

                        _message.setValue(t.getLocalizedMessage());

                    }
                });
    }
}
