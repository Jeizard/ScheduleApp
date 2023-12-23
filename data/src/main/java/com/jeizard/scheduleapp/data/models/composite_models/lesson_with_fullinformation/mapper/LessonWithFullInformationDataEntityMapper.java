package com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.entity.LessonWithFullInformationDataEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonWithFullInformationDataEntityMapper implements Mapper<LessonWithFullInformationDataEntity, com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation> {

    public LessonWithFullInformationDataEntityMapper() {
    }

    @Override
    public com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation mapFromDBEntity(LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity) {
        com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation lessonWithWeekDay  = null;
        if (lessonWithWeekDayDataEntity != null) {
            lessonWithWeekDay = new com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation(lessonWithWeekDayDataEntity.getId(),
                    lessonWithWeekDayDataEntity.getStartTime(),
                    lessonWithWeekDayDataEntity.getEndTime(),
                    lessonWithWeekDayDataEntity.getWeekDayTitle(),
                    lessonWithWeekDayDataEntity.getWeekDayAbbreviation(),
                    lessonWithWeekDayDataEntity.getSubjectTitle(),
                    lessonWithWeekDayDataEntity.getSubjectAbbreviation(),
                    lessonWithWeekDayDataEntity.getTeacherSurname(),
                    lessonWithWeekDayDataEntity.getTeacherName(),
                    lessonWithWeekDayDataEntity.getTeacherPatronymic(),
                    lessonWithWeekDayDataEntity.getCabinetNumber(),
                    lessonWithWeekDayDataEntity.getTypeTitle(),
                    lessonWithWeekDayDataEntity.getTypeAbbreviation());
        }
        return lessonWithWeekDay;
    }

    @Override
    public LessonWithFullInformationDataEntity mapToDBEntity(com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation lessonWithWeekDay) {
        LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity = null;
        if (lessonWithWeekDay != null) {
            lessonWithWeekDayDataEntity = new LessonWithFullInformationDataEntity(lessonWithWeekDay.getId(),
                    lessonWithWeekDay.getStartTime(),
                    lessonWithWeekDay.getEndTime(),
                    lessonWithWeekDay.getWeekDayTitle(),
                    lessonWithWeekDay.getWeekDayAbbreviation(),
                    lessonWithWeekDay.getSubjectTitle(),
                    lessonWithWeekDay.getSubjectAbbreviation(),
                    lessonWithWeekDay.getTeacherSurname(),
                    lessonWithWeekDay.getTeacherName(),
                    lessonWithWeekDay.getTeacherPatronymic(),
                    lessonWithWeekDay.getCabinetNumber(),
                    lessonWithWeekDay.getTypeTitle(),
                    lessonWithWeekDay.getTypeAbbreviation());
        }
        return lessonWithWeekDayDataEntity;
    }

    @Override
    public List<com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation> mapFromDBEntity(Collection<LessonWithFullInformationDataEntity> lessonWithWeekDayDataEntityCollection) {
        final List<com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation> lessonWithWeekDayList = new ArrayList<>();
        for (LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity : lessonWithWeekDayDataEntityCollection) {
            final com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation lessonWithWeekDay = mapFromDBEntity(lessonWithWeekDayDataEntity);
            if (lessonWithWeekDay != null) {
                lessonWithWeekDayList.add(lessonWithWeekDay);
            }
        }
        return lessonWithWeekDayList;
    }

    @Override
    public List<LessonWithFullInformationDataEntity> mapToDBEntity(Collection<com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation> lessonWithWeekDayCollection) {
        final List<LessonWithFullInformationDataEntity> lessonWithWeekDayDataEntityList = new ArrayList<>();
        for (com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation lessonWithWeekDay : lessonWithWeekDayCollection) {
            final LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity = mapToDBEntity(lessonWithWeekDay);
            if (lessonWithWeekDayDataEntity != null) {
                lessonWithWeekDayDataEntityList.add(lessonWithWeekDayDataEntity);
            }
        }
        return lessonWithWeekDayDataEntityList;
    }
}