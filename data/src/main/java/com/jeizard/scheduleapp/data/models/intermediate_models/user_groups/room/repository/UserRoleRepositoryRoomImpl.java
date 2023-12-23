package com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.dao.UserGroupDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.mapper.UserGroupDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.UserGroup;
import com.jeizard.scheduleapp.domain.model.entities.UserRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class UserRoleRepositoryRoomImpl extends BaseRepositoryRoomImpl<UserGroupDBEntity, UserGroupDao, UserGroup> implements BaseRepository<UserGroup> {
    private static final UserGroupDBEntityMapper userGroupDBEntityMapper = new UserGroupDBEntityMapper();

    public UserRoleRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).userGroupDao(), userGroupDBEntityMapper);
    }
}
