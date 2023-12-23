package com.jeizard.scheduleapp.data.models.single_models.faculties.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.faculties.room.entity.FacultyDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class FacultiesDao implements BaseDao<FacultyDBEntity> {

    @Query("DELETE FROM faculties")
    public abstract void deleteAllFaculties();

    @Query("SELECT * FROM faculties")
    public abstract List<FacultyDBEntity> getAllFaculties();

    @Override
    public void deleteAll() {
        deleteAllFaculties();
    }

    @Override
    public List<FacultyDBEntity> getAll() {
        return getAllFaculties();
    }
}
