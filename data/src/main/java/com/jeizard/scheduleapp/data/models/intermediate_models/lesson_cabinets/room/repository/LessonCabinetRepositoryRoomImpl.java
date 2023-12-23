package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.dao.LessonCabinetDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity.LessonCabinetDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.mapper.LessonCabinetDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonCabinet;
import com.jeizard.scheduleapp.domain.model.entities.LessonSubject;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonCabinetRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonCabinetDBEntity, LessonCabinetDao, LessonCabinet> implements BaseRepository<LessonCabinet> {
    private static final LessonCabinetDBEntityMapper lessonCabinetDBEntityMapper = new LessonCabinetDBEntityMapper();

    public LessonCabinetRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonCabinetDao(), lessonCabinetDBEntityMapper);
    }
}

