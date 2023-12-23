package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao.LessonTeachersDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.mapper.LessonTeachersDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonTeacher;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonTeachersRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonTeachersDBEntity, LessonTeachersDao, LessonTeacher> implements BaseRepository<LessonTeacher> {
    private static final LessonTeachersDBEntityMapper lessonTeachersDBEntityMapper = new LessonTeachersDBEntityMapper();

    public LessonTeachersRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonTeachersDao(), lessonTeachersDBEntityMapper);
    }
}

