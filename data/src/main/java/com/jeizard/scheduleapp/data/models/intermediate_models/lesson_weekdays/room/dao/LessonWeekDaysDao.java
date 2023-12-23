package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity.LessonWeekDaysDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonWeekDaysDao implements BaseDao<LessonWeekDaysDBEntity> {

    @Query("DELETE FROM lesson_weekdays")
    public abstract void deleteAllLessonsWeekDays();

    @Query("SELECT * FROM lesson_weekdays")
    public abstract List<LessonWeekDaysDBEntity> getAllLessonsWeekDays();

    @Override
    public void deleteAll() {
        deleteAllLessonsWeekDays();
    }

    @Override
    public List<LessonWeekDaysDBEntity> getAll() {
        return getAllLessonsWeekDays();
    }
}
