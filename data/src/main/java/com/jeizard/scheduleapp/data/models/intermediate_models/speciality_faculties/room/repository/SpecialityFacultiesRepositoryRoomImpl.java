package com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.dao.SpecialityFacultiesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.entity.SpecialityFacultiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.mapper.SpecialityFacultiesDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.SpecialityFaculty;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class SpecialityFacultiesRepositoryRoomImpl extends BaseRepositoryRoomImpl<SpecialityFacultiesDBEntity, SpecialityFacultiesDao, SpecialityFaculty> implements BaseRepository<SpecialityFaculty> {
    private static final SpecialityFacultiesDBEntityMapper specialityFacultiesDBEntityMapper = new SpecialityFacultiesDBEntityMapper();

    public SpecialityFacultiesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).specialityFacultiesDao(), specialityFacultiesDBEntityMapper);
    }
}
