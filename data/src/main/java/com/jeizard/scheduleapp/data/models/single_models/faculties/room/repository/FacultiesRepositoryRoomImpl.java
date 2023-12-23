package com.jeizard.scheduleapp.data.models.single_models.faculties.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.faculties.room.dao.FacultiesDao;
import com.jeizard.scheduleapp.data.models.single_models.faculties.room.entity.FacultyDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.faculties.room.mapper.FacultiesDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Faculty;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class FacultiesRepositoryRoomImpl extends BaseRepositoryRoomImpl<FacultyDBEntity, FacultiesDao, Faculty> implements BaseRepository<Faculty> {
    private static final FacultiesDBEntityMapper facultiesDBEntityMapper = new FacultiesDBEntityMapper();

    public FacultiesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).facultiesDao(), facultiesDBEntityMapper);
    }
}
