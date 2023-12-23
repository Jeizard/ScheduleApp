package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.jeizard.scheduleapp.databinding.FragmentCreatingGroupScheduleBinding;
import com.jeizard.scheduleapp.databinding.FragmentSelectingAddOptionBinding;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;
import com.jeizard.scheduleapp.domain.model.usecases.CreateGroupScheduleUseCase;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CreatingGroupScheduleFragment extends Fragment {

    private FragmentCreatingGroupScheduleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentCreatingGroupScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        binding.create.setOnClickListener(v -> {
            String groupNumber = String.valueOf(binding.number.getText());
            if(!groupNumber.equals("")) {
                if (groupNumber.length() >= 7) {
                    Toast.makeText(getContext(), "Длина группы не должна превышать 6",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    new CreateGroupScheduleUseCase(dailyScheduleViewModel.getGroupsRepository()).execute(new Group(0, groupNumber, true), dailyScheduleViewModel.getCurrentUserId());
                    ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                    if (scheduleActivity != null) {
                        scheduleActivity.onBackPressed();
                    }
                }
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