package com.zeyad.medicalapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zeyad.medicalapp.data.model.EmployeeResponse;
import com.zeyad.medicalapp.databinding.ItemEmptypeLayoutBinding;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeesHolder> {


    List<EmployeeResponse> emp;

    public void addEmp(List<EmployeeResponse> emp) {
        this.emp = emp;
       // notifyItemInserted(emp.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemEmptypeLayoutBinding binding = ItemEmptypeLayoutBinding.inflate(LayoutInflater.from(parent.getContext())
        ,parent,false);

        return new EmployeesHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesHolder holder, int position) {

        EmployeeResponse EmpModel = emp.get(position);

        holder.binding.EmpName.setText(EmpModel.getFirstName());
        holder.binding.EmpSpecialist.setText(EmpModel.getType());

    }

    @Override
    public int getItemCount() {
        if (emp != null)
            return emp.size();
        return 0;
    }

    static public class EmployeesHolder extends RecyclerView.ViewHolder {

        ItemEmptypeLayoutBinding binding;
        public EmployeesHolder(@NonNull ItemEmptypeLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
