package com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.GroupSpeciality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupSpecialtiesDBEntityMapper implements Mapper<GroupSpecialtiesDBEntity, GroupSpeciality> {

    public GroupSpecialtiesDBEntityMapper() {
    }

    @Override
    public GroupSpeciality mapFromDBEntity(GroupSpecialtiesDBEntity groupSpecialtiesDBEntity) {
        GroupSpeciality groupSpecialties = null;
        if (groupSpecialtiesDBEntity != null) {
            groupSpecialties = new GroupSpeciality(groupSpecialtiesDBEntity.getGroupId(), groupSpecialtiesDBEntity.getSpecialityId());
        }
        return groupSpecialties;
    }

    @Override
    public GroupSpecialtiesDBEntity mapToDBEntity(GroupSpeciality groupSpecialties) {
        GroupSpecialtiesDBEntity groupSpecialtiesDBEntity = null;
        if (groupSpecialties != null) {
            groupSpecialtiesDBEntity = new GroupSpecialtiesDBEntity(groupSpecialties.getGroupId(), groupSpecialties.getSpecialityId());
        }
        return groupSpecialtiesDBEntity;
    }

    @Override
    public List<GroupSpeciality> mapFromDBEntity(Collection<GroupSpecialtiesDBEntity> groupSpecialtiesDBEntityCollection) {
        final List<GroupSpeciality> groupSpecialtiesList = new ArrayList<>();
        for (GroupSpecialtiesDBEntity groupSpecialtiesDBEntity : groupSpecialtiesDBEntityCollection) {
            final GroupSpeciality groupSpecialties = mapFromDBEntity(groupSpecialtiesDBEntity);
            if (groupSpecialties != null) {
                groupSpecialtiesList.add(groupSpecialties);
            }
        }
        return groupSpecialtiesList;
    }

    @Override
    public List<GroupSpecialtiesDBEntity> mapToDBEntity(Collection<GroupSpeciality> groupSpecialtiesCollection) {
        final List<GroupSpecialtiesDBEntity> groupSpecialtiesDBEntityList = new ArrayList<>();
        for (GroupSpeciality groupSpecialties : groupSpecialtiesCollection) {
            final GroupSpecialtiesDBEntity groupSpecialtiesDBEntity = mapToDBEntity(groupSpecialties);
            if (groupSpecialtiesDBEntity != null) {
                groupSpecialtiesDBEntityList.add(groupSpecialtiesDBEntity);
            }
        }
        return groupSpecialtiesDBEntityList;
    }
}