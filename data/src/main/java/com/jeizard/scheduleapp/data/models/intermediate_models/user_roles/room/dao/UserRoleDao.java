package com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity.UserRoleDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class UserRoleDao implements BaseDao<UserRoleDBEntity> {

    @Query("DELETE FROM user_roles")
    public abstract void deleteAllUserRoles();

    @Query("SELECT * FROM user_roles")
    public abstract List<UserRoleDBEntity> getAllUserRoles();

    @Override
    public void deleteAll() {
        deleteAllUserRoles();
    }

    @Override
    public List<UserRoleDBEntity> getAll() {
        return getAllUserRoles();
    }
}
