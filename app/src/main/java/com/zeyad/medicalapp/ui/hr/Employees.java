package com.zeyad.medicalapp.ui.hr;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.data.model.EmployeeResponse;
import com.zeyad.medicalapp.data.model.EmployeesResponse;
import com.zeyad.medicalapp.data.source.remote.RetrofitClient;
import com.zeyad.medicalapp.databinding.FragmentEmployeesBinding;
import com.zeyad.medicalapp.ui.adapter.EmployeesAdapter;
import com.zeyad.medicalapp.viewmodel.EmployeesViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Employees extends Fragment {


    FragmentEmployeesBinding binding ;
    String token;
    List<EmployeeResponse> employeesResponses;
    EmployeesAdapter employeesAdapter;
    private EmployeesViewModel employeesViewModel;
    public Employees() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        employeesViewModel = new ViewModelProvider(this).get(EmployeesViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employees, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding=FragmentEmployeesBinding.bind(view);


        getAccessToken();
        binding.AllEmp.setBackgroundColor(getResources().getColor(R.color.main_color));
        observe("All",token);
        Listeners();
        InitRec();

    }

    private void InitRec() {

         employeesAdapter = new EmployeesAdapter();
         binding.employeesRec.setAdapter(employeesAdapter);
         binding.employeesRec.setLayoutManager(new LinearLayoutManager(requireContext()));

    }

    private void getAccessToken() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share"
                , Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token","");
    }


    private void observe(String type,String token) {

        Log.d("eeee","token :"+token);

        employeesViewModel.getEmployees(type,token);
        employeesViewModel.employeesLiveData.observe(getViewLifecycleOwner(), new Observer<EmployeesResponse>() {
            @Override
            public void onChanged(EmployeesResponse employeesResponse) {
                Log.d("eeeee","OnSuccess :"+employeesResponse);
                employeesResponses = employeesResponse.getData();
                employeesAdapter.addEmp(employeesResponses);
            }
        });

        employeesViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(), ""+s, Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void Listeners() {
        binding.AddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v)
                        .navigate(R.id.action_employees2_to_newUser);
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v)
                        .navigate(R.id.action_employees2_to_base2);
            }
        });



        binding.AllEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.Doctor.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AllEmp.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Nurse.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.HREmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AnaEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

                observe("All",token);

            }
        });
        binding.Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.AllEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.Doctor.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Nurse.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.HREmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AnaEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));


                observe("doctor",token);
            }
        });

        binding.Nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.Doctor.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.Nurse.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.AllEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.HREmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AnaEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

                observe("nurse",token);
            }
        });

        binding.AnaEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.Doctor.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AnaEmp.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Nurse.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.HREmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AllEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

                observe("analysis",token);
            }
        });

        binding.HREmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.Doctor.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.HREmp.setBackgroundColor(getResources().getColor(R.color.main_color));
                binding.Nurse.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AllEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));
                binding.AnaEmp.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_btn2));

                observe("hr",token);
            }
        });
    }
}

