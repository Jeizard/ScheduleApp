package com.jeizard.scheduleapp.data.models.single_models.week_days.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class WeekDaysDao implements BaseDao<WeekDayDBEntity> {


    @Query("DELETE FROM week_days")
    public abstract void deleteAllWeekDays();

    @Query("SELECT * FROM week_days")
    public abstract List<WeekDayDBEntity> getAllWeekDays();

    @Override
    public void deleteAll() {
        deleteAllWeekDays();
    }

    @Override
    public List<WeekDayDBEntity> getAll() {
        return getAllWeekDays();
    }

    @Query("SELECT id FROM week_days WHERE title=:title")
    public abstract int getWeekDayIdByTitle(String title);
}
