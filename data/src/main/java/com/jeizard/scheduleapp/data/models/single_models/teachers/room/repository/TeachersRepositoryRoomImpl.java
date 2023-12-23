package com.jeizard.scheduleapp.data.models.single_models.teachers.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.dao.TeachersDao;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.mapper.TeacherDBEntityMapper;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Teacher;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class TeachersRepositoryRoomImpl extends BaseRepositoryRoomImpl<TeacherDBEntity, TeachersDao, Teacher> implements BaseRepository<Teacher> {
    private static final TeacherDBEntityMapper teacherDBEntityMapper = new TeacherDBEntityMapper();

    public TeachersRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).teachersDao(), teacherDBEntityMapper);
    }
}
