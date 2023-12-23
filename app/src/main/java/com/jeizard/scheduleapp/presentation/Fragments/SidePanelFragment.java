package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jeizard.scheduleapp.databinding.FragmentSidePanelBinding;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.usecases.ReloadTrackedGroupUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.UpdateTrackedGroupUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.UploadLocalGroupToGlobalGroupsUseCase;
import com.jeizard.scheduleapp.presentation.ActionListeners.ScheduleActionListener;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;
import com.jeizard.scheduleapp.presentation.Adapters.ScheduleAdapter;
import com.jeizard.scheduleapp.presentation.ViewModels.AddingSchedulesByGroupsViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.AddingSchedulesByGroupsViewModelFactory;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SidePanelFragment extends Fragment {

    private FragmentSidePanelBinding binding;
    private ScheduleAdapter scheduleAdapter;
    private Group selectedGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSidePanelBinding.inflate(inflater, container, false);
        ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
        if (scheduleActivity != null) {
            selectedGroup = scheduleActivity.getLastSelectedGroup();
            if(selectedGroup == null){
                selectedGroup = new Group();
            }
        }
        else{
            selectedGroup = new Group();
        }
        return binding.getRoot();

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);
        AddingSchedulesByGroupsViewModel addingSchedulesByGroupsViewModel = new ViewModelProvider(getActivity(), new AddingSchedulesByGroupsViewModelFactory(getActivity().getApplication()))
                .get(AddingSchedulesByGroupsViewModel.class);
        switch (item.getItemId()) {
            case 3:
                new ReloadTrackedGroupUseCase(dailyScheduleViewModel.getGroupsRepository()).execute(scheduleAdapter.selectedGroupContex, dailyScheduleViewModel.getCurrentUserId());
                break;
            case 4:
                if(selectedGroup.getNumber().equals(scheduleAdapter.selectedGroupContex.getNumber())){ //не равны, хотя равны selectedGroup.equals(scheduleAdapter.selectedGroupContex)
                    if(dailyScheduleViewModel.trackedGroups.getValue().size() > 1){
                        dailyScheduleViewModel.setSelectedGroup(dailyScheduleViewModel.trackedGroups.getValue().get(0));
                    }
                    else{
                        dailyScheduleViewModel.setSelectedGroup(new Group());
                    }
                }
                dailyScheduleViewModel.getGroupsRepository().delete(scheduleAdapter.selectedGroupContex, dailyScheduleViewModel.getCurrentUserId());
                break;
            case 5:
                new UploadLocalGroupToGlobalGroupsUseCase(addingSchedulesByGroupsViewModel.getGroupsRepository()).execute(scheduleAdapter.selectedGroupContex);
                new UpdateTrackedGroupUseCase(dailyScheduleViewModel.getGroupsRepository()).execute(new Group(scheduleAdapter.selectedGroupContex.getId(), scheduleAdapter.selectedGroupContex.getNumber(), false), dailyScheduleViewModel.getCurrentUserId());
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.searchLine.clearFocus();

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(), new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        dailyScheduleViewModel.setSelectedGroup(selectedGroup);

        scheduleAdapter = new ScheduleAdapter(new ScheduleActionListener() {
            @Override
            public void onGroupSelected(Group group) {
                selectedGroup = group;
                dailyScheduleViewModel.setSelectedGroup(selectedGroup);
//                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
//                if (scheduleActivity != null) {
//                    scheduleActivity.displayDailyScheduleFragment();
//                }
                getActivity().onBackPressed();
            }
        },
                getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        dailyScheduleViewModel.selectedGroup.observe(getActivity(), selectedGroup -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.setLastSelectedGroup(selectedGroup);
            }
            scheduleAdapter.setSelectedGroup(selectedGroup);
        });

        dailyScheduleViewModel.trackedGroups.observe(getActivity(), groups -> {
            scheduleAdapter.setGroups(groups);
            binding.recyclerView.setAdapter(scheduleAdapter);
            if(scheduleAdapter.getSelectedGroupIndex() != -1){
                dailyScheduleViewModel.setSelectedGroup(groups.get(scheduleAdapter.getSelectedGroupIndex()));
            }
        });

        binding.addSchedule.setOnClickListener(v -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.displaySelectingAddOptionFragment();
            }
        });

        binding.blackout.setOnClickListener(v -> {
//            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
//            if (scheduleActivity != null) {
//                scheduleActivity.displayDailyScheduleFragment();
//            }
            getActivity().onBackPressed();
        });
    }
}