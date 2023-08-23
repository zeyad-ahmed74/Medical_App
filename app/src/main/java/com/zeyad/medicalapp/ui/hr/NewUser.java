package com.zeyad.medicalapp.ui.hr;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.zeyad.medicalapp.R;
import com.zeyad.medicalapp.data.model.RegistrationResponse;
import com.zeyad.medicalapp.data.model.request.RegisterRequest;
import com.zeyad.medicalapp.data.source.remote.RetrofitClient;
import com.zeyad.medicalapp.databinding.FragmentNewUserBinding;
import com.zeyad.medicalapp.viewmodel.RegisterViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUser extends Fragment {

    FragmentNewUserBinding binding;
    RegisterViewModel registerViewModel;

    ArrayAdapter<String> genderArrayAdapter;
    String [] genders = {"Male","Female","Other"};

    ArrayAdapter<String> specialistArrayAdapter;
    String [] specialists = {"Base","Doctor","Receptionist","Nurse","Analysis","Manager"};

    ArrayAdapter<String> statuesArrayAdapter;
    String [] statues = {"Single","Married"};

    final Calendar myCalendar = Calendar.getInstance();

    RegisterRequest request;

    public NewUser() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding=FragmentNewUserBinding.bind(view);

        Gender();
        Specialist();
        DateOfBirth();
        Statues();


        binding.createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               observe();
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v)
                        .navigate(R.id.action_newUser_to_employees2);
            }
        });

    }

    private void observe() {

        registerViewModel.CreateNewUser(RequestObject());
        registerViewModel.registerLiveData.observe(getViewLifecycleOwner(), new Observer<RegistrationResponse>() {
            @Override
            public void onChanged(RegistrationResponse registrationResponse) {
                Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show();
                Log.d("pppppp",""+registrationResponse.getMessage());

            }
        });

        registerViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(), ""+s, Toast.LENGTH_SHORT).show();
            }
        });
        clearEditText();
    }


    private void clearEditText() {
        Objects.requireNonNull(binding.firstName.getText()).clear();
        Objects.requireNonNull(binding.lastName.getText()).clear();
        Objects.requireNonNull(binding.genderAutoComplete.getText()).clear();
        Objects.requireNonNull(binding.specialistsAutoComplete.getText()).clear();
        Objects.requireNonNull(binding.birthdayAutoComplete.getText()).clear();
        Objects.requireNonNull(binding.statuesAutoComplete.getText()).clear();
        Objects.requireNonNull(binding.mobile.getText()).clear();
        Objects.requireNonNull(binding.email.getText()).clear();
        Objects.requireNonNull(binding.address.getText()).clear();
        Objects.requireNonNull(binding.password.getText()).clear();


    }

    private RegisterRequest RequestObject() {
                request = new RegisterRequest(
                 Objects.requireNonNull(binding.firstName.getText()).toString().trim()
                , Objects.requireNonNull(binding.lastName.getText()).toString().trim()
                ,binding.genderAutoComplete.getText().toString().trim()
                ,binding.specialistsAutoComplete.getText().toString().trim()
                ,binding.birthdayAutoComplete.getText().toString().trim()
                ,binding.statuesAutoComplete.getText().toString().trim()
                , Objects.requireNonNull(binding.mobile.getText()).toString().trim()
                , Objects.requireNonNull(binding.email.getText()).toString().trim()
                , Objects.requireNonNull(binding.address.getText()).toString().trim()
                , Objects.requireNonNull(binding.password.getText()).toString().trim()
                ,binding.specialistsAutoComplete.getText().toString().trim());

                return request;
    }


    private void DateOfBirth() {

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR , year);
                myCalendar.set(Calendar.MONTH , month);
                myCalendar.set(Calendar.DAY_OF_MONTH , dayOfMonth);
                updateLabel();


            }
        };
        binding.birthdayAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(requireContext(),date,myCalendar.get(Calendar.YEAR)
                        ,myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String MyFormat = "dd/MM/yy";
        SimpleDateFormat DateFormat = new SimpleDateFormat(MyFormat , Locale.US);
        binding.birthdayAutoComplete.setText(DateFormat.format(myCalendar.getTime()));
    }


    private void Specialist() {
        specialistArrayAdapter = new ArrayAdapter<>(requireContext(),R.layout.drop_down_item,specialists);
        binding.specialistsAutoComplete.setAdapter(specialistArrayAdapter);
    }

    private void Gender() {
        genderArrayAdapter = new ArrayAdapter<>(requireContext(),R.layout.drop_down_item, genders);
        binding.genderAutoComplete.setAdapter(genderArrayAdapter);
    }
    private void Statues() {

        statuesArrayAdapter = new ArrayAdapter<>(requireContext(),R.layout.drop_down_item,statues);
        binding.statuesAutoComplete.setAdapter(statuesArrayAdapter);
    }
}
