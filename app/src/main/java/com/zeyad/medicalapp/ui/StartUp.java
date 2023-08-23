package com.zeyad.medicalapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.databinding.FragmentStartUpBinding;


public class StartUp extends Fragment {

    FragmentStartUpBinding binding;

    public StartUp () {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStartUpBinding.inflate(getLayoutInflater(),container ,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListeners();

    }



    private void setListeners(){
        binding.HR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("hr"));

            }
        });

        binding.Recep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("receptionist"));

            }
        });

        binding.Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("doctor"));

            }
        });

        binding.AnaEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("analysis"));

            }
        });

        binding.Manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("manager"));

            }
        });

        binding.Nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Navigation.findNavController(requireView())
                        .navigate(StartUpDirections.actionStartUpToLogin6("nurse"));

            }
        });

    }


}