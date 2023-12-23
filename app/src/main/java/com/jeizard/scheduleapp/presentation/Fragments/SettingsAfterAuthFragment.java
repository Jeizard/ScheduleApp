package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jeizard.scheduleapp.databinding.FragmentSettingAfterAuthenticationBinding;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SettingsAfterAuthFragment extends Fragment {

    private FragmentSettingAfterAuthenticationBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSettingAfterAuthenticationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if(currentUser != null){
            binding.email.setText(currentUser.getEmail());
        }

        binding.scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.onBackPressed();
                }
            }
        });

        binding.signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.onBackPressed();
                }
            }
        });
    }
}