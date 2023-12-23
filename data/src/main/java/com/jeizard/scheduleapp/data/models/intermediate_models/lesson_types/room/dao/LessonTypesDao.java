package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity.LessonTypesDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonTypesDao implements BaseDao<LessonTypesDBEntity> {

    @Query("DELETE FROM lesson_types")
    public abstract void deleteAllLessonTypes();

    @Query("SELECT * FROM lesson_types")
    public abstract List<LessonTypesDBEntity> getAllLessonTypes();

    @Override
    public void deleteAll() {
        deleteAllLessonTypes();
    }

    @Override
    public List<LessonTypesDBEntity> getAll() {
        return getAllLessonTypes();
    }
}
