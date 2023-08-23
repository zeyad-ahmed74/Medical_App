package com.zeyad.medicalapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.data.model.Data;
import com.zeyad.medicalapp.databinding.FragmentBaseBinding;
import com.zeyad.medicalapp.viewmodel.LoginViewModel;

import java.util.Objects;

public class Base extends Fragment {

    FragmentBaseBinding binding;
    Data data ;
    private LoginViewModel loginViewModel;
    public Base() {
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
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentBaseBinding.bind(view);


       Intent i = getActivity().getIntent();
       data = (Data) i.getSerializableExtra("info");

        Log.d("xxxxxx",""+data);


        if(Objects.equals(data.getSpecialist().toLowerCase(),"hr")) {
            binding.employee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_base2_to_employees2);
                }
            });

        }
        if(Objects.equals(data.getSpecialist().toLowerCase(),"nurse")) {
            binding.cases.setVisibility(View.VISIBLE);
            binding.calls.setVisibility(View.VISIBLE);
            binding.calls.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_base2_to_calls3);
                }
            });

            binding.cases.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_base2_to_caseDetails);
                }
            });
        }
        if(Objects.equals(data.getSpecialist().toLowerCase(),"doctor")) {
            binding.cases.setVisibility(View.VISIBLE);
            binding.calls.setVisibility(View.VISIBLE);
            binding.calls.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_base2_to_calls3);
                }
            });
            binding.cases.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_base2_to_caseDetails);
                }
            });


        }



        binding.name.setText(data.getFirstName()+" "+data.getLastName());
        binding.specialist.setText("Specialist,"+data.getSpecialist());



        binding.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v)
                        .navigate(R.id.action_base2_to_myProfile2);
            }
        });

        binding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v)
                        .navigate(R.id.action_base2_to_myProfile2);
            }
        });





    }




}