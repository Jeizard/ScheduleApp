package com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.dao.GroupYearsFormsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.entity.GroupYearsFormsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.mapper.GroupYearsFormsDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.GroupYearsForms;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class GroupYearsFormsRepositoryRoomImpl extends BaseRepositoryRoomImpl<GroupYearsFormsDBEntity, GroupYearsFormsDao, GroupYearsForms> implements BaseRepository<GroupYearsForms> {
    private static final GroupYearsFormsDBEntityMapper groupYearsFormsDBEntityMapper = new GroupYearsFormsDBEntityMapper();

    public GroupYearsFormsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).groupYearsFormsDao(), groupYearsFormsDBEntityMapper);
    }
}
