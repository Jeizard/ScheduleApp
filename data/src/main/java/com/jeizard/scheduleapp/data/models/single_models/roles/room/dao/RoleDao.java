package com.jeizard.scheduleapp.data.models.single_models.roles.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class RoleDao implements BaseDao<RoleDBEntity> {


    @Query("DELETE FROM roles")
    public abstract void deleteAllRoles();

    @Query("SELECT * FROM roles")
    public abstract List<RoleDBEntity> getAllRoles();

    @Override
    public void deleteAll() {
        deleteAllRoles();
    }

    @Override
    public List<RoleDBEntity> getAll() {
        return getAllRoles();
    }
}
