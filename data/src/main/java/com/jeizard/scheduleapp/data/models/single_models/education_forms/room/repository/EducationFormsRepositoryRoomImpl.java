package com.jeizard.scheduleapp.data.models.single_models.education_forms.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.dao.EducationFormsDao;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity.EducationFormDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.mapper.EducationFormsDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.EducationForm;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class EducationFormsRepositoryRoomImpl extends BaseRepositoryRoomImpl<EducationFormDBEntity, EducationFormsDao, EducationForm> implements BaseRepository<EducationForm> {
    private static final EducationFormsDBEntityMapper educationFormsDBEntityMapper = new EducationFormsDBEntityMapper();

    public EducationFormsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).educationFormsDao(), educationFormsDBEntityMapper);
    }
}
