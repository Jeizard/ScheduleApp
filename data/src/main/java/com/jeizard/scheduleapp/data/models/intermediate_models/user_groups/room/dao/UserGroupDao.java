package com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class UserGroupDao implements BaseDao<UserGroupDBEntity> {

    @Query("DELETE FROM user_groups")
    public abstract void deleteAllUserGroups();

    @Query("SELECT * FROM user_groups")
    public abstract List<UserGroupDBEntity> getAllUserGroups();

    @Override
    public void deleteAll() {
        deleteAllUserGroups();
    }

    @Override
    public List<UserGroupDBEntity> getAll() {
        return getAllUserGroups();
    }

    @Query("SELECT * " +
            "FROM user_groups " +
            "WHERE user_id = :userId")
    public abstract List<UserGroupDBEntity> getAllGroupsByUserId(int userId);
}
