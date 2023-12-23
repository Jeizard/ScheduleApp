package com.jeizard.scheduleapp.data.models.single_models.study_years.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.single_models.study_years.room.dao.StudyYearsDao;
import com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity.StudyYearDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.study_years.room.mapper.StudyYearsDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.StudyYear;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class StudyYearsRepositoryRoomImpl extends BaseRepositoryRoomImpl<StudyYearDBEntity, StudyYearsDao, StudyYear> implements BaseRepository<StudyYear> {
    private static final StudyYearsDBEntityMapper studyYearsDBEntityMapper = new StudyYearsDBEntityMapper();

    public StudyYearsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).studyYearsDao(), studyYearsDBEntityMapper);
    }
}
