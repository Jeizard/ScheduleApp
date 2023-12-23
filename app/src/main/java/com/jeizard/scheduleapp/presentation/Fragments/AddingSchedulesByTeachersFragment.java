package com.jeizard.scheduleapp.presentation.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jeizard.scheduleapp.databinding.FragmentAddingSchedulesByGroupsBinding;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.LessonWithWeekDayRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;
import com.jeizard.scheduleapp.domain.model.usecases.AddGroupToListFollowedUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.GetFilteredGroupWithSpecialityListUseCase;
import com.jeizard.scheduleapp.presentation.ActionListeners.GroupActionListener;
import com.jeizard.scheduleapp.presentation.Adapters.GroupAdapter;
import com.jeizard.scheduleapp.presentation.ViewModels.AddingSchedulesByGroupsViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.AddingSchedulesByGroupsViewModelFactory;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AddingSchedulesByTeachersFragment extends Fragment {

    private FragmentAddingSchedulesByGroupsBinding binding;
    private GroupAdapter groupAdapter;
    private AddGroupToListFollowedUseCase addGroupToListFollowedUseCase;
    private LocalGroupRepository groupsRepository;
    private LessonWithWeekDayRepository lessonWithWeekDayRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentAddingSchedulesByGroupsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(), new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        groupAdapter = new GroupAdapter(new GroupActionListener() {
            @Override
            public void onGroupAdd(GroupWithFullInformation groupWithSpeciality) {
                Group group = new Group(groupWithSpeciality.getId(), groupWithSpeciality.getNumber(), false); // groupWithSpeciality.getLocal()
                boolean groupExists = dailyScheduleViewModel.trackedGroups.getValue().stream()
                        .anyMatch(existingGroup -> existingGroup.getNumber().equals(group.getNumber()));

                if (!groupExists) {
                    groupsRepository = dailyScheduleViewModel.getGroupsRepository();
                    addGroupToListFollowedUseCase = new AddGroupToListFollowedUseCase(group, groupsRepository);
                    addGroupToListFollowedUseCase.execute(dailyScheduleViewModel.getCurrentUserId());
                    dailyScheduleViewModel.setSelectedGroup(group);
                    Toast.makeText(getContext(), "Group: " + group.getNumber(), Toast.LENGTH_SHORT).show();
                    getActivity().onBackPressed();
                }
                else{
                    Toast.makeText(getContext(), "Already added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.backButton.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.searchLine.clearFocus();

        binding.filterGroupButton.setOnClickListener(v -> {
            binding.recyclerView.smoothScrollToPosition(0);
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        AddingSchedulesByGroupsViewModel addingSchedulesByGroupsViewModel = new ViewModelProvider(getActivity(), new AddingSchedulesByGroupsViewModelFactory(getActivity().getApplication()))
                .get(AddingSchedulesByGroupsViewModel.class);

        addingSchedulesByGroupsViewModel.allGroupsWithSpecialtiesLive.observe(getActivity(), groupWithSpecialityList -> {
            groupAdapter.setGroupWithSpecialityAndFacultyList(groupWithSpecialityList);
            binding.recyclerView.setAdapter(groupAdapter);
        });

        binding.searchLine.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                groupAdapter.setGroupWithSpecialityAndFacultyList(new GetFilteredGroupWithSpecialityListUseCase(addingSchedulesByGroupsViewModel.allGroupsWithSpecialtiesLive.getValue(), newText).execute());
                return true;
            }
        });

        addingSchedulesByGroupsViewModel.loadAllGroups();
    }


}