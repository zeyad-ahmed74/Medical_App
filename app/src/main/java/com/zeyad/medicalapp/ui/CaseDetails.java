package com.zeyad.medicalapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.databinding.FragmentCaseDetailsBinding;


public class CaseDetails extends Fragment {


    FragmentCaseDetailsBinding binding;

    public CaseDetails() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_case_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = FragmentCaseDetailsBinding.bind(view);

        setListeners();
    }

    private void setListeners() {

        binding.Case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.Case.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.medRec.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.medMea.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

            }
        });

        binding.medRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.medRec.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Case.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.medMea.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

            }
        });

        binding.medMea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.medMea.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Case.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.medRec.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

            }
        });

        binding.reqNurseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_caseDetails_to_listNurses);
            }
        });

    }


}