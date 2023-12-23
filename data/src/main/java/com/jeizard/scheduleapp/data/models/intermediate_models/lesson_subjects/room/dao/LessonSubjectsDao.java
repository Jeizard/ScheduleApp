package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonSubjectsDao implements BaseDao<LessonSubjectsDBEntity> {

    @Query("DELETE FROM lesson_subjects")
    public abstract void deleteAllLessonSubject();

    @Query("SELECT * FROM lesson_subjects")
    public abstract List<LessonSubjectsDBEntity> getAllLessonSubject();

    @Override
    public void deleteAll() {
        deleteAllLessonSubject();
    }

    @Override
    public List<LessonSubjectsDBEntity> getAll() {
        return getAllLessonSubject();
    }
}
