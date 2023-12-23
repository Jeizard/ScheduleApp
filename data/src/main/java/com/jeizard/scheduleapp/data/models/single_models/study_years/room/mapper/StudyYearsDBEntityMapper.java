package com.jeizard.scheduleapp.data.models.single_models.study_years.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity.StudyYearDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.StudyYear;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudyYearsDBEntityMapper implements Mapper<StudyYearDBEntity, StudyYear> {

    public StudyYearsDBEntityMapper() {
    }

    @Override
    public StudyYear mapFromDBEntity(StudyYearDBEntity studyYearDBEntity) {
        StudyYear studyYear = null;
        if (studyYearDBEntity != null) {
            studyYear = new StudyYear(studyYearDBEntity.getId(), studyYearDBEntity.getNumber());
        }
        return studyYear;
    }

    @Override
    public StudyYearDBEntity mapToDBEntity(StudyYear studyYear) {
        StudyYearDBEntity studyYearDBEntity = null;
        if (studyYear != null) {
            studyYearDBEntity = new StudyYearDBEntity(studyYear.getId(), studyYear.getNumber());
        }
        return studyYearDBEntity;
    }

    @Override
    public List<StudyYear> mapFromDBEntity(Collection<StudyYearDBEntity> studyYearDBEntityCollection) {
        final List<StudyYear> studyYearList = new ArrayList<>();
        for (StudyYearDBEntity studyYearDBEntity : studyYearDBEntityCollection) {
            final StudyYear studyYear = mapFromDBEntity(studyYearDBEntity);
            if (studyYear != null) {
                studyYearList.add(studyYear);
            }
        }
        return studyYearList;
    }

    @Override
    public List<StudyYearDBEntity> mapToDBEntity(Collection<StudyYear> studyYearCollection) {
        final List<StudyYearDBEntity> studyYearDBEntityList = new ArrayList<>();
        for (StudyYear studyYear : studyYearCollection) {
            final StudyYearDBEntity studyYearDBEntity = mapToDBEntity(studyYear);
            if (studyYearDBEntity != null) {
                studyYearDBEntityList.add(studyYearDBEntity);
            }
        }
        return studyYearDBEntityList;
    }
}