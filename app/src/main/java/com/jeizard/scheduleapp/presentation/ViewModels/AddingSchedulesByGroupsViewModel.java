package com.jeizard.scheduleapp.presentation.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;

import java.util.List;

public class AddingSchedulesByGroupsViewModel extends ViewModel {
    private GroupRepository groupsRepository;
    private BaseRepository<GroupWithFullInformation> groupWithSpecialityRepository;
    public MutableLiveData<List<GroupWithFullInformation>> allGroupsWithSpecialtiesLive = new MutableLiveData<List<GroupWithFullInformation>>();

    public AddingSchedulesByGroupsViewModel(GroupRepository groupsRepository, BaseRepository<GroupWithFullInformation> groupWithSpecialityRepository) {
        this.groupsRepository = groupsRepository;
        this.groupWithSpecialityRepository = groupWithSpecialityRepository;
    }

    public GroupRepository getGroupsRepository() {
        return groupsRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void loadAllGroups(){
        groupWithSpecialityRepository.addListener(listener);
    }

    private BaseRepository.OnDataChangedListener<GroupWithFullInformation> listener = groupWithSpecialityList -> allGroupsWithSpecialtiesLive.setValue(groupWithSpecialityList);
}
