package com.jeizard.scheduleapp.data.models.single_models.subjects.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.subjects.room.dao.SubjectsDao;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.mapper.SubjectDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;
import com.jeizard.scheduleapp.domain.model.entities.Subject;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class SpecialtiesRepositoryRoomImpl extends BaseRepositoryRoomImpl<SubjectDBEntity, SubjectsDao, Subject> implements BaseRepository<Subject> {
    private static final SubjectDBEntityMapper specialityDBEntityMapper = new SubjectDBEntityMapper();

    public SpecialtiesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).subjectsDao(), specialityDBEntityMapper);
    }
}

