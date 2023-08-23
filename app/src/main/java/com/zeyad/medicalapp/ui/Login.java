package com.zeyad.medicalapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeyad.medicalapp.data.model.LoginResponse;
import com.zeyad.medicalapp.data.model.request.LoginRequest;
import com.zeyad.medicalapp.databinding.FragmentLoginBinding;
import com.zeyad.medicalapp.ui.hr.HRActivity;
import com.zeyad.medicalapp.viewmodel.LoginViewModel;

import java.util.Locale;


public class Login extends Fragment {

    FragmentLoginBinding binding;
    String specialist;
    private LoginViewModel loginViewModel;
    public Login() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
       // cashMyData();

    }


    private void setListeners() {
        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              observe();

           }
        });
     }

    private void observe() {

        specialist = LoginArgs.fromBundle(getArguments()).getSpecialist();
        LoginRequest loginRequest = new LoginRequest(binding.email.getEditText().getText().toString()
               ,binding.password.getEditText().getText().toString());

        loginViewModel.checkLogin(loginRequest);
        loginViewModel.loginLiveData.observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {

                if(specialist.equals(loginResponse.getData().getSpecialist().toLowerCase(Locale.ROOT))) {

                    if(loginResponse.getData().getSpecialist().toLowerCase(Locale.ROOT).equals("hr")) {
                        Intent intent = new Intent(getActivity(), HRActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("info", loginResponse.getData());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                   else if(loginResponse.getData().getSpecialist().toLowerCase(Locale.ROOT).equals("doctor")) {
                        Intent intent = new Intent(getActivity(), HRActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("info", loginResponse.getData());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else if(loginResponse.getData().getSpecialist().toLowerCase(Locale.ROOT).equals("nurse")) {
                        Intent intent = new Intent(getActivity(), HRActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("info", loginResponse.getData());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(requireContext(),"Wrong User Type",Toast.LENGTH_LONG).show();
                }
            }
        });

        loginViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(),""+s,Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    private void cashMyData(){
//
//        SharedPreferences share = requireContext().getSharedPreferences("share",Context.MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = share.edit();
//        editor.putString("email",binding.email.getEditText().getText().toString());
//        editor.putString("pass",binding.password.getEditText().getText().toString());
//
//
//    }
}