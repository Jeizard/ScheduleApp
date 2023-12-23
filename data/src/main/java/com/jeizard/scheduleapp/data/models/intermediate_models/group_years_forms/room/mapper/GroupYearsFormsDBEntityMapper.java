package com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.entity.GroupYearsFormsDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.GroupYearsForms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupYearsFormsDBEntityMapper implements Mapper<GroupYearsFormsDBEntity, GroupYearsForms> {

    public GroupYearsFormsDBEntityMapper() {
    }

    @Override
    public GroupYearsForms mapFromDBEntity(GroupYearsFormsDBEntity groupYearsFormsDBEntity) {
        GroupYearsForms groupYearsForms = null;
        if (groupYearsFormsDBEntity != null) {
            groupYearsForms = new GroupYearsForms(groupYearsFormsDBEntity.getGroupId(), groupYearsFormsDBEntity.getYearId(), groupYearsFormsDBEntity.getFormId());
        }
        return groupYearsForms;
    }

    @Override
    public GroupYearsFormsDBEntity mapToDBEntity(GroupYearsForms groupYearsForms) {
        GroupYearsFormsDBEntity groupYearsFormsDBEntity = null;
        if (groupYearsForms != null) {
            groupYearsFormsDBEntity = new GroupYearsFormsDBEntity(groupYearsForms.getGroupId(), groupYearsForms.getYearId(), groupYearsForms.getFormId());
        }
        return groupYearsFormsDBEntity;
    }

    @Override
    public List<GroupYearsForms> mapFromDBEntity(Collection<GroupYearsFormsDBEntity> groupYearsFormsDBEntityCollection) {
        final List<GroupYearsForms> groupYearsFormsList = new ArrayList<>();
        for (GroupYearsFormsDBEntity groupYearsFormsDBEntity : groupYearsFormsDBEntityCollection) {
            final GroupYearsForms groupYearsForms = mapFromDBEntity(groupYearsFormsDBEntity);
            if (groupYearsForms != null) {
                groupYearsFormsList.add(groupYearsForms);
            }
        }
        return groupYearsFormsList;
    }

    @Override
    public List<GroupYearsFormsDBEntity> mapToDBEntity(Collection<GroupYearsForms> groupYearsFormsCollection) {
        final List<GroupYearsFormsDBEntity> groupYearsFormsDBEntityList = new ArrayList<>();
        for (GroupYearsForms groupYearsForms : groupYearsFormsCollection) {
            final GroupYearsFormsDBEntity groupYearsFormsDBEntity = mapToDBEntity(groupYearsForms);
            if (groupYearsFormsDBEntity != null) {
                groupYearsFormsDBEntityList.add(groupYearsFormsDBEntity);
            }
        }
        return groupYearsFormsDBEntityList;
    }
}