package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.jeizard.scheduleapp.databinding.FragmentLoginBinding;
import com.jeizard.scheduleapp.databinding.FragmentSettingBeforeAuthenticationBinding;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SettingsBeforeAuthFragment extends Fragment {

    private FragmentSettingBeforeAuthenticationBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSettingBeforeAuthenticationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.onBackPressed();
                }
            }
        });

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.displayLoginFragment();
                }
            }
        });

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.displayRegisterFragment();
                }
            }
        });
    }
}