package com.mk.infits.fragments.live;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;
import com.mk.infits.R;
import com.mk.infits.adapters.RecycPersonalAdapter;
import com.mk.infits.adapters.live.RecycLiveViewers;
import com.mk.infits.adapters.live.RecycUpcomingLive;
import com.mk.infits.databinding.FragmentLiveMainBinding;
import com.mk.infits.model.PersonalDetailsModel;
import com.mk.infits.model.live.LiveUpcomingModel;

import java.util.ArrayList;


public class LiveMainFragment extends Fragment {

    FragmentLiveMainBinding binding;

    //Upcoming Live
    ArrayList<LiveUpcomingModel> liveUpcomingModel = new ArrayList<>();
    RecycUpcomingLive upcomingLiveAdapter;

    //Live viewers
    ArrayList<LiveUpcomingModel> liveViewersModel = new ArrayList<>();
    RecycLiveViewers liveViewersAdapter;

    public LiveMainFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLiveMainBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.liveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new LiveScheduleFragment());
            }
        });

        getUpcomingLive();
        getLiveViewers();

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_cont,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Animatoo.animateSlideLeft(requireContext());
    }

    private void getLiveViewers() {
        liveViewersModel.add(new LiveUpcomingModel(R.drawable.profile_img));
        liveViewersModel.add(new LiveUpcomingModel(R.drawable.profile_img));
        liveViewersModel.add(new LiveUpcomingModel(R.drawable.profile_img));
        liveViewersModel.add(new LiveUpcomingModel(R.drawable.profile_img));

        liveViewersAdapter = new RecycLiveViewers(getContext(), liveViewersModel, new RecycLiveViewers.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Snackbar.make(binding.getRoot(), ""+liveViewersModel.get(position).getUserName(), Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.recycViewers.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        binding.recycViewers.setAdapter(liveViewersAdapter);
        liveViewersAdapter.notifyDataSetChanged();
    }

    private void getUpcomingLive() {

        liveUpcomingModel.add(new LiveUpcomingModel("Jhon Wyane","09/05/2022","2.00 pm"));
        liveUpcomingModel.add(new LiveUpcomingModel("Jhon Wyane","09/05/2022","2.00 pm"));
        liveUpcomingModel.add(new LiveUpcomingModel("Jhon Wyane","09/05/2022","2.00 pm"));
        liveUpcomingModel.add(new LiveUpcomingModel("Jhon Wyane","09/05/2022","2.00 pm"));

        upcomingLiveAdapter = new RecycUpcomingLive(getContext(), liveUpcomingModel, new RecycUpcomingLive.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Snackbar.make(binding.getRoot(), ""+liveUpcomingModel.get(position).getUserName(), Snackbar.LENGTH_SHORT).show();
            }
        });

        binding.recycUpcomingLive.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recycUpcomingLive.setAdapter(upcomingLiveAdapter);
        upcomingLiveAdapter.notifyDataSetChanged();

    }
}