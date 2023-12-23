package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.dao.LessonTypesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity.LessonTypesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.mapper.LessonTypesDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonTypes;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonTypesRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonTypesDBEntity, LessonTypesDao, LessonTypes> implements BaseRepository<LessonTypes> {
    private static final LessonTypesDBEntityMapper lessonTeachersDBEntityMapper = new LessonTypesDBEntityMapper();

    public LessonTypesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonTypesDao(), lessonTeachersDBEntityMapper);
    }
}

