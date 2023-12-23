package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jeizard.scheduleapp.databinding.FragmentSelectingAddOptionBinding;
import com.jeizard.scheduleapp.databinding.FragmentSelectingCreateOptionBinding;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SelectingCreateOptionFragment extends Fragment {

    private FragmentSelectingCreateOptionBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSelectingCreateOptionBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.groupButton.setOnClickListener(v -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.displayCreatingGroupScheduleFragment();
            }
        });

        binding.close.setOnClickListener(v -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.onBackPressed();
            }
        });
    }
}