package com.jeizard.scheduleapp.data.models.single_models.groups.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class GroupsDao implements BaseDao<GroupDBEntity> {

    @Query("DELETE FROM groups")
    public abstract void deleteAllGroups();

    @Query("SELECT * FROM groups")
    public abstract List<GroupDBEntity> getAllGroups();

    @Override
    public void deleteAll() {
        deleteAllGroups();
    }

    @Override
    public List<GroupDBEntity> getAll() {
        return getAllGroups();
    }

    @Query("SELECT id " +
            "FROM groups " +
            "WHERE number = :groupNumber AND is_local = 0")
    public abstract int getGlobalGroupIdByNumber(String groupNumber);

    @Query("SELECT * " +
            "FROM groups " +
            "WHERE id = :id")
    public abstract GroupDBEntity getById(int id);
}
