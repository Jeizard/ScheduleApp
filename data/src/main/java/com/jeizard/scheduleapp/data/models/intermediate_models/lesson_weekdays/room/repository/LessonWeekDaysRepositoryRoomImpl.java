package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.dao.LessonWeekDaysDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity.LessonWeekDaysDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.mapper.LessonWeekDaysDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonWeekDay;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonWeekDaysRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonWeekDaysDBEntity, LessonWeekDaysDao, LessonWeekDay> implements BaseRepository<LessonWeekDay> {
    private static final LessonWeekDaysDBEntityMapper lessonWeekDaysDBEntityMapper = new LessonWeekDaysDBEntityMapper();

    public LessonWeekDaysRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonWeekDaysDao(), lessonWeekDaysDBEntityMapper);
    }
}
