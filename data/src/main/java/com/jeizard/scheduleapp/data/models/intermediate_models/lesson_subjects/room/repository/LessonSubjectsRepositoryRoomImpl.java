package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.dao.LessonSubjectsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.mapper.LessonSubjectsDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonSubject;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonSubjectsRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonSubjectsDBEntity, LessonSubjectsDao, LessonSubject> implements BaseRepository<LessonSubject> {
    private static final LessonSubjectsDBEntityMapper lessonTeachersDBEntityMapper = new LessonSubjectsDBEntityMapper();

    public LessonSubjectsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonSubjectsDao(), lessonTeachersDBEntityMapper);
    }
}

