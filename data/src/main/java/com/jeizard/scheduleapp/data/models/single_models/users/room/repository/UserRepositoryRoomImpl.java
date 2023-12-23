package com.jeizard.scheduleapp.data.models.single_models.users.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.users.room.dao.UserDao;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.users.room.mapper.UserDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.User;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class UserRepositoryRoomImpl extends BaseRepositoryRoomImpl<UserDBEntity, UserDao, User> implements BaseRepository<User> {
    private static final UserDBEntityMapper userDBEntityMapper = new UserDBEntityMapper();

    public UserRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).userDao(), userDBEntityMapper);
    }
}
