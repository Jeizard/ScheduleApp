package com.jeizard.scheduleapp.presentation.ViewModels.Factories;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.repository.LessonWithFullInformationRepositoryRoomImpl;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.sharedpreferences.repository.LessonWithWeekDayRepositorySharedPreferencesImpl;
import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.repository.UserWithRoleRepositoryRoomImpl;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.repository.GroupsRepositorySharedPreferencesImpl;
import com.jeizard.scheduleapp.data.models.single_models.users.room.repository.UserRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.User;
import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.LessonWithWeekDayRepository;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;


public class DailyScheduleViewModelFactory implements ViewModelProvider.Factory {
    private Activity activity;
    private Application application;

    public DailyScheduleViewModelFactory(Activity activity, Application application) {
        this.activity = activity;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        LocalGroupRepository groupsRepository = new GroupsRepositorySharedPreferencesImpl(activity, application);
        LessonsWithFullInformationRepository lessonsWithFullInformationRepository = new LessonWithFullInformationRepositoryRoomImpl(application);
        BaseRepository<UserWithRole> userWithRoleRepository = new UserWithRoleRepositoryRoomImpl(application);
        return (T) new DailyScheduleViewModel(groupsRepository, lessonsWithFullInformationRepository, userWithRoleRepository);
    }
}
