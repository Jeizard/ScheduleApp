package com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.entity.SpecialityFacultiesDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.SpecialityFaculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpecialityFacultiesDBEntityMapper implements Mapper<SpecialityFacultiesDBEntity, SpecialityFaculty> {

    public SpecialityFacultiesDBEntityMapper() {
    }

    @Override
    public SpecialityFaculty mapFromDBEntity(SpecialityFacultiesDBEntity specialityFacultiesDBEntity) {
        SpecialityFaculty specialityFaculties = null;
        if (specialityFacultiesDBEntity != null) {
            specialityFaculties = new SpecialityFaculty(specialityFacultiesDBEntity.getSpecialityId(), specialityFacultiesDBEntity.getFacultyId());
        }
        return specialityFaculties;
    }

    @Override
    public SpecialityFacultiesDBEntity mapToDBEntity(SpecialityFaculty specialityFaculties) {
        SpecialityFacultiesDBEntity specialityFacultiesDBEntity = null;
        if (specialityFaculties != null) {
            specialityFacultiesDBEntity = new SpecialityFacultiesDBEntity(specialityFaculties.getSpecialityId(), specialityFaculties.getFacultyId());
        }
        return specialityFacultiesDBEntity;
    }

    @Override
    public List<SpecialityFaculty> mapFromDBEntity(Collection<SpecialityFacultiesDBEntity> specialityFacultiesDBEntityCollection) {
        final List<SpecialityFaculty> specialityFacultiesList = new ArrayList<>();
        for (SpecialityFacultiesDBEntity specialityFacultiesDBEntity : specialityFacultiesDBEntityCollection) {
            final SpecialityFaculty specialityFaculties = mapFromDBEntity(specialityFacultiesDBEntity);
            if (specialityFaculties != null) {
                specialityFacultiesList.add(specialityFaculties);
            }
        }
        return specialityFacultiesList;
    }

    @Override
    public List<SpecialityFacultiesDBEntity> mapToDBEntity(Collection<SpecialityFaculty> specialityFacultiesCollection) {
        final List<SpecialityFacultiesDBEntity> specialityFacultiesDBEntityList = new ArrayList<>();
        for (SpecialityFaculty specialityFaculties : specialityFacultiesCollection) {
            final SpecialityFacultiesDBEntity specialityFacultiesDBEntity = mapToDBEntity(specialityFaculties);
            if (specialityFacultiesDBEntity != null) {
                specialityFacultiesDBEntityList.add(specialityFacultiesDBEntity);
            }
        }
        return specialityFacultiesDBEntityList;
    }
}