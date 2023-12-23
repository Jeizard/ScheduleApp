package com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.repository;

import android.app.Application;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.dao.GroupSpecialtiesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.mapper.GroupSpecialtiesDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.GroupSpeciality;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class GroupSpecialtiesRepositoryRoomImpl extends BaseRepositoryRoomImpl<GroupSpecialtiesDBEntity, GroupSpecialtiesDao, GroupSpeciality> implements BaseRepository<GroupSpeciality> {
    private static final GroupSpecialtiesDBEntityMapper groupSpecialtiesDBEntityMapper = new GroupSpecialtiesDBEntityMapper();

    public GroupSpecialtiesRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).groupSpecialtiesDao(), groupSpecialtiesDBEntityMapper);
    }
}
