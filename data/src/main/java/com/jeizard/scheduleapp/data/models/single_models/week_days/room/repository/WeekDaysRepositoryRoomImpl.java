package com.jeizard.scheduleapp.data.models.single_models.week_days.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.week_days.room.dao.WeekDaysDao;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.mapper.WeekDayDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.WeekDay;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class WeekDaysRepositoryRoomImpl extends BaseRepositoryRoomImpl<WeekDayDBEntity, WeekDaysDao, WeekDay> implements BaseRepository<WeekDay> {
    private static final WeekDayDBEntityMapper weekDayDBEntityMapper = new WeekDayDBEntityMapper();

    public WeekDaysRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).weekDaysDao(), weekDayDBEntityMapper);
    }
}

