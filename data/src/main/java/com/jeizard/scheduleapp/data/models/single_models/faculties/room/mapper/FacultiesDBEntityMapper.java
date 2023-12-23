package com.jeizard.scheduleapp.data.models.single_models.faculties.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.faculties.room.entity.FacultyDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Faculty;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FacultiesDBEntityMapper implements Mapper<FacultyDBEntity, Faculty> {

    public FacultiesDBEntityMapper() {
    }

    @Override
    public Faculty mapFromDBEntity(FacultyDBEntity facultyDBEntity) {
        Faculty faculty = null;
        if (facultyDBEntity != null) {
            faculty = new Faculty(facultyDBEntity.getId(), facultyDBEntity.getTitle(), facultyDBEntity.getAbbreviation());
        }
        return faculty;
    }

    @Override
    public FacultyDBEntity mapToDBEntity(Faculty faculty) {
        FacultyDBEntity facultyDBEntity = null;
        if (faculty != null) {
            facultyDBEntity = new FacultyDBEntity(faculty.getId(), faculty.getTitle(), faculty.getAbbreviation());
        }
        return facultyDBEntity;
    }

    @Override
    public List<Faculty> mapFromDBEntity(Collection<FacultyDBEntity> facultyDBEntityCollection) {
        final List<Faculty> facultyList = new ArrayList<>();
        for (FacultyDBEntity facultyDBEntity : facultyDBEntityCollection) {
            final Faculty faculty = mapFromDBEntity(facultyDBEntity);
            if (faculty != null) {
                facultyList.add(faculty);
            }
        }
        return facultyList;
    }

    @Override
    public List<FacultyDBEntity> mapToDBEntity(Collection<Faculty> facultyCollection) {
        final List<FacultyDBEntity> facultyDBEntityList = new ArrayList<>();
        for (Faculty faculty : facultyCollection) {
            final FacultyDBEntity specialityDBEntity = mapToDBEntity(faculty);
            if (specialityDBEntity != null) {
                facultyDBEntityList.add(specialityDBEntity);
            }
        }
        return facultyDBEntityList;
    }
}