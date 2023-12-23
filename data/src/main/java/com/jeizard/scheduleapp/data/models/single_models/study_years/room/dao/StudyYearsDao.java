package com.jeizard.scheduleapp.data.models.single_models.study_years.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity.StudyYearDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class StudyYearsDao implements BaseDao<StudyYearDBEntity> {

    @Query("DELETE FROM study_years")
    public abstract void deleteAllStudyYears();

    @Query("SELECT * FROM study_years")
    public abstract List<StudyYearDBEntity> getAllStudyYears();

    @Override
    public void deleteAll() {
        deleteAllStudyYears();
    }

    @Override
    public List<StudyYearDBEntity> getAll() {
        return getAllStudyYears();
    }
}
