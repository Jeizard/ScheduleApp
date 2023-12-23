package com.jeizard.scheduleapp.data.models.single_models.lessons.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.dao.LessonsDao;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.mapper.LessonDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Lesson;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonsRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonDBEntity, LessonsDao, Lesson> implements BaseRepository<Lesson> {
    private static final LessonDBEntityMapper lessonDBEntityMapper = new LessonDBEntityMapper();

    public LessonsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonsDao(), lessonDBEntityMapper);
    }
}
