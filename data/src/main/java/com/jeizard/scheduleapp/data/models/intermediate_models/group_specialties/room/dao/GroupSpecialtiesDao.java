package com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class GroupSpecialtiesDao implements BaseDao<GroupSpecialtiesDBEntity> {

    @Query("DELETE FROM group_specialties")
    public abstract void deleteAllGroupSpecialties();

    @Query("SELECT * FROM group_specialties")
    public abstract List<GroupSpecialtiesDBEntity> getAllGroupSpecialties();

    @Override
    public void deleteAll() {
        deleteAllGroupSpecialties();
    }

    @Override
    public List<GroupSpecialtiesDBEntity> getAll() {
        return getAllGroupSpecialties();
    }
}
