package com.mk.infits.fragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;
import com.mk.infits.MainActivity;
import com.mk.infits.R;
import com.mk.infits.adapters.RecycPersonalAdapter;
import com.mk.infits.databinding.FragmentPersonalDetailsBinding;
import com.mk.infits.model.PersonalDetailsModel;

import net.skoumal.fragmentback.BackFragment;

import java.util.ArrayList;
import java.util.Objects;

public class PersonalDetailsFragment extends Fragment implements BackFragment {

   FragmentPersonalDetailsBinding binding;

    //Personal Details
    ArrayList<PersonalDetailsModel> perDelModel = new ArrayList<>();
    RecycPersonalAdapter perAdapter;

    public PersonalDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPersonalDetailsBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView backImg = requireActivity().findViewById(R.id.menu);
        backImg.setBackground(getResources().getDrawable(R.drawable.back));
        backImg.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_700)));
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getPersonalDetails();

    }

    private void getPersonalDetails() {
        perDelModel.add(new PersonalDetailsModel("Gender","Male"));
        perDelModel.add(new PersonalDetailsModel("Weight","50kg"));
        perDelModel.add(new PersonalDetailsModel("BMI","20.2"));
        perDelModel.add(new PersonalDetailsModel("Height","65 feet"));
        perDelModel.add(new PersonalDetailsModel("Phone No","8686767688"));
        perDelModel.add(new PersonalDetailsModel("Email Id","ronalrichard@gmail.com"));
        perDelModel.add(new PersonalDetailsModel("Subscribed Plan","Muscle Gain"));
        perDelModel.add(new PersonalDetailsModel("Start Date","10 March 2022"));
        perDelModel.add(new PersonalDetailsModel("End Date","10 March 2023"));

        perAdapter = new RecycPersonalAdapter(getContext(), perDelModel, new RecycPersonalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Snackbar.make(binding.getRoot(), ""+perDelModel.get(position).getTitle() + perDelModel.get(position).getDesc(), Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.recycPersonalDetails.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.recycPersonalDetails.setAdapter(perAdapter);
        perAdapter.notifyDataSetChanged();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_cont,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onBackPressed() {
        DashboardFragment dashFrag = new DashboardFragment();
        FragmentTransaction transaction = Objects.requireNonNull(requireActivity()).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_cont,dashFrag);
        transaction.commit();
        return true;
    }

    @Override
    public int getBackPriority() {
        return NORMAL_BACK_PRIORITY;
    }
}