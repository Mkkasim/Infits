package com.mk.infits.fragments.live;

import static com.mk.infits.model.live.CalenderUtils.daysInWeekArray;
import static com.mk.infits.model.live.CalenderUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mk.infits.R;
import com.mk.infits.adapters.live.CalendarAdapter;
import com.mk.infits.databinding.FragmentLiveScheduleBinding;
import com.mk.infits.model.live.CalenderUtils;

import java.time.LocalDate;
import java.util.ArrayList;


public class LiveScheduleFragment extends Fragment implements CalendarAdapter.OnItemListener{

    FragmentLiveScheduleBinding binding;

    public LiveScheduleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLiveScheduleBinding.inflate(inflater,container,false);
        return binding.getRoot();



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setWeekView();

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderUtils.selectedDate = CalenderUtils.selectedDate.plusWeeks(1);
                setWeekView();
            }
        });

        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderUtils.selectedDate = CalenderUtils.selectedDate.minusWeeks(1);
                setWeekView();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setWeekView()
    {
        //binding.monthYearTV.setText(monthYearFromDate(CalenderUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalenderUtils.selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireContext(), 7);
        binding.calendarRecyclerView.setLayoutManager(layoutManager);
        binding.calendarRecyclerView.setAdapter(calendarAdapter);
        //setEventAdpater();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, LocalDate date)
    {
        CalenderUtils.selectedDate = date;
        setWeekView();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //setEventAdpater();
    }

//    private void setEventAdpater()
//    {
//        ArrayList<Event> dailyEvents = Event.eventsForDate(CalendarUtils.selectedDate);
//        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
//        eventListView.setAdapter(eventAdapter);
//    }

//    public void newEventAction(View view)
//    {
//        startActivity(new Intent(this, EventEditActivity.class));
//    }
}