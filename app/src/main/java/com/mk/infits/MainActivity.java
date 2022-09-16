package com.mk.infits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.os.Bundle;

import com.mk.infits.databinding.ActivityMainBinding;
import com.mk.infits.fragments.DashboardFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.menu.setBackground(getResources().getDrawable(R.drawable.nav_icon));
        binding.menu.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_700)));
        replaceFragment(new DashboardFragment());

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_cont,fragment);
        fragmentTransaction.commit();
    }
}