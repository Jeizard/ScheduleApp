package com.jeizard.scheduleapp.data.models.single_models.specialties.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.specialties.room.dao.SpecialtiesDao;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.mapper.SpecialityDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class SpecialtiesRepositoryRoomImpl extends BaseRepositoryRoomImpl<SpecialityDBEntity, SpecialtiesDao, Speciality> implements BaseRepository<Speciality> {
    private static final SpecialityDBEntityMapper specialityDBEntityMapper = new SpecialityDBEntityMapper();

    public SpecialtiesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).specialtiesDao(), specialityDBEntityMapper);
    }
}

