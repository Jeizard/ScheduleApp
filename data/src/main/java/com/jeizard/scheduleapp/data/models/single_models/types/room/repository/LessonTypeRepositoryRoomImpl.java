package com.jeizard.scheduleapp.data.models.single_models.types.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.types.room.dao.LessonTypeDao;
import com.jeizard.scheduleapp.data.models.single_models.types.room.entity.LessonTypeDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.types.room.mapper.LessonTypeDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonType;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonTypeRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonTypeDBEntity, LessonTypeDao, LessonType> implements BaseRepository<LessonType> {
    private static final LessonTypeDBEntityMapper lessonTypeDBEntityMapper = new LessonTypeDBEntityMapper();

    public LessonTypeRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonTypeDao(), lessonTypeDBEntityMapper);
    }
}
