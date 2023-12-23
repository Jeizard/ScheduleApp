package com.jeizard.scheduleapp.presentation.ViewModels.Factories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.repository.GroupWithFullInformationRepositoryRoomImpl;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.repository.GroupsRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;
import com.jeizard.scheduleapp.presentation.ViewModels.AddingSchedulesByGroupsViewModel;


public class AddingSchedulesByGroupsViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    public AddingSchedulesByGroupsViewModelFactory(Application application) {
        this.application = application;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        GroupRepository groupsRepository = new GroupsRepositoryRoomImpl(application);
        BaseRepository<GroupWithFullInformation> groupWithSpecialityAndFacultyRepositoryRoom = new GroupWithFullInformationRepositoryRoomImpl(application, groupsRepository);
        return (T) new AddingSchedulesByGroupsViewModel(groupsRepository, groupWithSpecialityAndFacultyRepositoryRoom);
    }
}
