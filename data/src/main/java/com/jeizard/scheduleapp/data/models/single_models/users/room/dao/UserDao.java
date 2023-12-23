package com.jeizard.scheduleapp.data.models.single_models.users.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class UserDao implements BaseDao<UserDBEntity> {


    @Query("DELETE FROM users")
    public abstract void deleteAllUsers();

    @Query("SELECT * FROM users")
    public abstract List<UserDBEntity> getAllUsers();

    @Override
    public void deleteAll() {
        deleteAllUsers();
    }

    @Override
    public List<UserDBEntity> getAll() {
        return getAllUsers();
    }
}
