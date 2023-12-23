package com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.entity.GroupYearsFormsDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class GroupYearsFormsDao implements BaseDao<GroupYearsFormsDBEntity> {

    @Query("DELETE FROM group_years_forms")
    public abstract void deleteAllGroupYearsForms();

    @Query("SELECT * FROM group_years_forms")
    public abstract List<GroupYearsFormsDBEntity> getAllGroupYearsForms();

    @Override
    public void deleteAll() {
        deleteAllGroupYearsForms();
    }

    @Override
    public List<GroupYearsFormsDBEntity> getAll() {
        return getAllGroupYearsForms();
    }
}
