package com.jeizard.scheduleapp.data.models.single_models.types.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.types.room.entity.LessonTypeDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonTypeDao implements BaseDao<LessonTypeDBEntity> {

    @Query("DELETE FROM types")
    public abstract void deleteAllLessonTypes();

    @Query("SELECT * FROM types")
    public abstract List<LessonTypeDBEntity> getAllLessonTypes();

    @Override
    public void deleteAll() {
        deleteAllLessonTypes();
    }

    @Override
    public List<LessonTypeDBEntity> getAll() {
        return getAllLessonTypes();
    }

    @Query("SELECT id FROM types WHERE title=:title")
    public abstract int getTypeIdByTitle(String title);
}
