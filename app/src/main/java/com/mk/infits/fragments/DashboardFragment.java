package com.mk.infits.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;
import com.mk.infits.R;
import com.mk.infits.databinding.FragmentDashboardBinding;
import com.mk.infits.fragments.live.LiveMainFragment;


public class DashboardFragment extends Fragment {

   FragmentDashboardBinding binding;

    public DashboardFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView menuImg = requireActivity().findViewById(R.id.menu);
        menuImg.setBackground(getResources().getDrawable(R.drawable.nav_icon));
        menuImg.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_700)));

        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(binding.getRoot(),"Open Drawer",Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.relatePersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.relatePersonal.setBackground(getResources().getDrawable(R.drawable.personal_round_clicked));
                binding.personalInfoImg.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.personalText.setTextColor(getResources().getColor(R.color.white));
                binding.personalDes.setTextColor(getResources().getColor(R.color.white));
                replaceFragment(new PersonalDetailsFragment());
            }
        });

        binding.relateChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.relateChat.setBackground(getResources().getDrawable(R.drawable.personal_round_clicked));
                //binding.chatsImg.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.chatsText.setTextColor(getResources().getColor(R.color.white));
                binding.chatsDes.setTextColor(getResources().getColor(R.color.white));
                replaceFragment(new LiveMainFragment());
            }
        });

        binding.relateHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.relateHealth.setBackground(getResources().getDrawable(R.drawable.health_round_clicked));
                //binding.chatsImg.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.healthText.setTextColor(getResources().getColor(R.color.white));
                binding.healthDes.setTextColor(getResources().getColor(R.color.white));
                replaceFragment(new CameraFilesFragment());
            }
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_cont,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Animatoo.animateSlideLeft(requireContext());
    }
}