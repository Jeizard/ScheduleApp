package com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.dao.UserRoleDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity.UserRoleDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.mapper.UserRoleDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonWeekDay;
import com.jeizard.scheduleapp.domain.model.entities.UserRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class UserRoleRepositoryRoomImpl extends BaseRepositoryRoomImpl<UserRoleDBEntity, UserRoleDao, UserRole> implements BaseRepository<UserRole> {
    private static final UserRoleDBEntityMapper userRoleDBEntityMapper = new UserRoleDBEntityMapper();

    public UserRoleRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).userRoleDao(), userRoleDBEntityMapper);
    }
}
