package com.jeizard.scheduleapp.data.models.single_models.roles.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.roles.room.dao.RoleDao;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.mapper.RoleDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Role;
import com.jeizard.scheduleapp.domain.model.entities.User;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class RoleRepositoryRoomImpl extends BaseRepositoryRoomImpl<RoleDBEntity, RoleDao, Role> implements BaseRepository<Role> {
    private static final RoleDBEntityMapper roleDBEntityMapper = new RoleDBEntityMapper();

    public RoleRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).roleDao(), roleDBEntityMapper);
    }
}
