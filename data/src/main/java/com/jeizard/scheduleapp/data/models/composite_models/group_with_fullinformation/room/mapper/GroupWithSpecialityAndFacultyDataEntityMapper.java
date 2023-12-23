package com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.entity.GroupWithFullInformationDataEntity;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupWithSpecialityAndFacultyDataEntityMapper implements Mapper<GroupWithFullInformationDataEntity, GroupWithFullInformation> {

    public GroupWithSpecialityAndFacultyDataEntityMapper() {
    }

    @Override
    public GroupWithFullInformation mapFromDBEntity(GroupWithFullInformationDataEntity groupWithSpecialityDataEntity) {
        GroupWithFullInformation groupWithSpeciality = null;
        if (groupWithSpecialityDataEntity != null) {
            groupWithSpeciality = new GroupWithFullInformation(groupWithSpecialityDataEntity.getId(),
                    groupWithSpecialityDataEntity.getNumber(),
                    groupWithSpecialityDataEntity.getLocal(),
                    groupWithSpecialityDataEntity.getSpecialityTitle(),
                    groupWithSpecialityDataEntity.getSpecialityAbbreviation(),
                    groupWithSpecialityDataEntity.getFacultyTitle(),
                    groupWithSpecialityDataEntity.getFacultyAbbreviation(),
                    groupWithSpecialityDataEntity.getStudyYearNumber(),
                    groupWithSpecialityDataEntity.getEducationFormTitle());
        }
        return groupWithSpeciality;
    }

    @Override
    public GroupWithFullInformationDataEntity mapToDBEntity(GroupWithFullInformation groupWithSpeciality) {
        GroupWithFullInformationDataEntity groupWithSpecialityDataEntity = null;
        if (groupWithSpeciality != null) {
            groupWithSpecialityDataEntity = new GroupWithFullInformationDataEntity(groupWithSpeciality.getId(),
                    groupWithSpeciality.getNumber(),
                    groupWithSpeciality.getLocal(),
                    groupWithSpeciality.getSpecialityTitle(),
                    groupWithSpeciality.getSpecialityAbbreviation(),
                    groupWithSpeciality.getFacultyTitle(),
                    groupWithSpeciality.getFacultyAbbreviation(),
                    groupWithSpeciality.getStudyYearNumber(),
                    groupWithSpeciality.getEducationFormTitle());
        }
        return groupWithSpecialityDataEntity;
    }

    @Override
    public List<GroupWithFullInformation> mapFromDBEntity(Collection<GroupWithFullInformationDataEntity> groupWithSpecialityDataEntityCollection) {
        final List<GroupWithFullInformation> groupWithSpecialityList = new ArrayList<>();
        for (GroupWithFullInformationDataEntity groupWithSpecialityDataEntity : groupWithSpecialityDataEntityCollection) {
            final GroupWithFullInformation groupWithSpeciality = mapFromDBEntity(groupWithSpecialityDataEntity);
            if (groupWithSpeciality != null) {
                groupWithSpecialityList.add(groupWithSpeciality);
            }
        }
        return groupWithSpecialityList;
    }

    @Override
    public List<GroupWithFullInformationDataEntity> mapToDBEntity(Collection<GroupWithFullInformation> groupWithSpecialityCollection) {
        final List<GroupWithFullInformationDataEntity> groupWithSpecialityDataEntityList = new ArrayList<>();
        for (GroupWithFullInformation groupWithSpeciality : groupWithSpecialityCollection) {
            final GroupWithFullInformationDataEntity groupWithSpecialityDataEntity = mapToDBEntity(groupWithSpeciality);
            if (groupWithSpecialityDataEntity != null) {
                groupWithSpecialityDataEntityList.add(groupWithSpecialityDataEntity);
            }
        }
        return groupWithSpecialityDataEntityList;
    }
}