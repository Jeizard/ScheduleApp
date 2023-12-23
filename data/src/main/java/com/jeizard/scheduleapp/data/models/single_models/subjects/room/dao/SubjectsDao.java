package com.jeizard.scheduleapp.data.models.single_models.subjects.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class SubjectsDao implements BaseDao<SubjectDBEntity> {


    @Query("DELETE FROM subjects")
    public abstract void deleteAllSubjects();

    @Query("SELECT * FROM subjects")
    public abstract List<SubjectDBEntity> getAllSubjects();

    @Override
    public void deleteAll() {
        deleteAllSubjects();
    }

    @Override
    public List<SubjectDBEntity> getAll() {
        return getAllSubjects();
    }
}
