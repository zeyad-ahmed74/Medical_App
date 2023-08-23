package com.zeyad.medicalapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeyad.medicalapp.data.model.EmployeeResponse;
import com.zeyad.medicalapp.data.model.EmployeesResponse;
import com.zeyad.medicalapp.databinding.FragmentListNursesBinding;
import com.zeyad.medicalapp.ui.adapter.EmployeesAdapter;
import com.zeyad.medicalapp.viewmodel.EmployeesViewModel;

import java.util.List;


public class ListNurses extends Fragment {


    FragmentListNursesBinding binding;
    List<EmployeeResponse> nurseResponse;
    String token;
    EmployeesAdapter adapter;

    private EmployeesViewModel viewModel;


    public ListNurses() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(EmployeesViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_nurses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding = FragmentListNursesBinding.bind(view);

        receiveToken();
        observe("nurse",token);
        InitRec();
    }



    private void observe(String type , String token) {

        viewModel.getEmployees(type,token);
        viewModel.employeesLiveData.observe(getViewLifecycleOwner(), new Observer<EmployeesResponse>() {
            @Override
            public void onChanged(EmployeesResponse employeesResponse) {

                nurseResponse = employeesResponse.getData();
                adapter.addEmp(nurseResponse);
            }
        });

        viewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(), ""+s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitRec() {

        adapter = new EmployeesAdapter();
        binding.nursesRec.setAdapter(adapter);
        binding.nursesRec.setLayoutManager(new LinearLayoutManager(requireContext()));


    }

    private void receiveToken() {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");
    }
}