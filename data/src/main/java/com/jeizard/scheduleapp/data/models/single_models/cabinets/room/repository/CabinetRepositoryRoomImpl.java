package com.jeizard.scheduleapp.data.models.single_models.cabinets.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.dao.CabinetDao;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.mapper.CabinetDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Cabinet;
import com.jeizard.scheduleapp.domain.model.entities.Subject;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class CabinetRepositoryRoomImpl extends BaseRepositoryRoomImpl<CabinetDBEntity, CabinetDao, Cabinet> implements BaseRepository<Cabinet> {
    private static final CabinetDBEntityMapper cabinetDBEntityMapper = new CabinetDBEntityMapper();

    public CabinetRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).cabinetDao(), cabinetDBEntityMapper);
    }
}

