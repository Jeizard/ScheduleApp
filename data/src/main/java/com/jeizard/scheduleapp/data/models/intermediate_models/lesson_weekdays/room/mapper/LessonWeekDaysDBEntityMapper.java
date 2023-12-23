package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity.LessonWeekDaysDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonWeekDay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonWeekDaysDBEntityMapper implements Mapper<LessonWeekDaysDBEntity, LessonWeekDay> {

    public LessonWeekDaysDBEntityMapper() {
    }

    @Override
    public LessonWeekDay mapFromDBEntity(LessonWeekDaysDBEntity lessonWeekDayDBEntity) {
        LessonWeekDay lessonWeekDay = null;
        if (lessonWeekDayDBEntity != null) {
            lessonWeekDay = new LessonWeekDay(lessonWeekDayDBEntity.getLessonId(), lessonWeekDayDBEntity.getWeekdayId());
        }
        return lessonWeekDay;
    }

    @Override
    public LessonWeekDaysDBEntity mapToDBEntity(LessonWeekDay lessonWeekDay) {
        LessonWeekDaysDBEntity lessonWeekDayDBEntity = null;
        if (lessonWeekDay != null) {
            lessonWeekDayDBEntity = new LessonWeekDaysDBEntity(lessonWeekDay.getLessonId(), lessonWeekDay.getWeekdayId());
        }
        return lessonWeekDayDBEntity;
    }

    @Override
    public List<LessonWeekDay> mapFromDBEntity(Collection<LessonWeekDaysDBEntity> lessonWeekDayDBEntityCollection) {
        final List<LessonWeekDay> lessonWeekDaysList = new ArrayList<>();
        for (LessonWeekDaysDBEntity lessonWeekDayDBEntity : lessonWeekDayDBEntityCollection) {
            final LessonWeekDay lessonWeekDays = mapFromDBEntity(lessonWeekDayDBEntity);
            if (lessonWeekDays != null) {
                lessonWeekDaysList.add(lessonWeekDays);
            }
        }
        return lessonWeekDaysList;
    }

    @Override
    public List<LessonWeekDaysDBEntity> mapToDBEntity(Collection<LessonWeekDay> lessonWeekDaysCollection) {
        final List<LessonWeekDaysDBEntity> lessonWeekDayDBEntityList = new ArrayList<>();
        for (LessonWeekDay lessonWeekDays : lessonWeekDaysCollection) {
            final LessonWeekDaysDBEntity lessonWeekDayDBEntity = mapToDBEntity(lessonWeekDays);
            if (lessonWeekDayDBEntity != null) {
                lessonWeekDayDBEntityList.add(lessonWeekDayDBEntity);
            }
        }
        return lessonWeekDayDBEntityList;
    }
}