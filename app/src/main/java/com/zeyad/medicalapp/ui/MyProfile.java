package com.zeyad.medicalapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.data.model.Data;
import com.zeyad.medicalapp.databinding.FragmentMyProfileBinding;

public class MyProfile extends Fragment {


    FragmentMyProfileBinding binding;
    private Data data;




    public MyProfile() {
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
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentMyProfileBinding.bind(view);

        //Receive Data

        Intent i = getActivity().getIntent();
        data = (Data) i.getSerializableExtra("info");


        putData();
    }

    private void putData() {
        binding.MyName.setText(data.getFirstName()+" "+data.getLastName());
        binding.Specialist.setText("Specialist-"+data.getSpecialist());
        binding.Gender.setText(data.getGender());
        binding.BirthDay.setText(data.getBirthday());
        binding.Address.setText(data.getAddress());
        binding.Status.setText(data.getStatus());
        binding.Email.setText(data.getEmail());
        binding.Phone.setText(data.getMobile());
    }

}