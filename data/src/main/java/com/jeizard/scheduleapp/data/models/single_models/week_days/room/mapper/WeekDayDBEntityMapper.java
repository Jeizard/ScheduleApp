package com.jeizard.scheduleapp.data.models.single_models.week_days.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.WeekDay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeekDayDBEntityMapper implements Mapper<WeekDayDBEntity, WeekDay> {

    public WeekDayDBEntityMapper() {
    }

    @Override
    public WeekDay mapFromDBEntity(WeekDayDBEntity weekDayDBEntity) {
        WeekDay weekDay = null;
        if (weekDayDBEntity != null) {
            weekDay = new WeekDay(weekDayDBEntity.getId(), weekDayDBEntity.getTitle(), weekDayDBEntity.getAbbreviation());
        }
        return weekDay;
    }

    @Override
    public WeekDayDBEntity mapToDBEntity(WeekDay weekDay) {
        WeekDayDBEntity weekDayDBEntity = null;
        if (weekDay != null) {
            weekDayDBEntity = new WeekDayDBEntity(weekDay.getId(), weekDay.getTitle(), weekDay.getAbbreviation());
        }
        return weekDayDBEntity;
    }

    @Override
    public List<WeekDay> mapFromDBEntity(Collection<WeekDayDBEntity> weekDayDBEntityCollection) {
        final List<WeekDay> weekDayList = new ArrayList<>();
        for (WeekDayDBEntity weekDayDBEntity : weekDayDBEntityCollection) {
            final WeekDay weekDay = mapFromDBEntity(weekDayDBEntity);
            if (weekDay != null) {
                weekDayList.add(weekDay);
            }
        }
        return weekDayList;
    }

    @Override
    public List<WeekDayDBEntity> mapToDBEntity(Collection<WeekDay> weekDayCollection) {
        final List<WeekDayDBEntity> weekDayDBEntityList = new ArrayList<>();
        for (WeekDay weekDay : weekDayCollection) {
            final WeekDayDBEntity weekDayDBEntity = mapToDBEntity(weekDay);
            if (weekDayDBEntity != null) {
                weekDayDBEntityList.add(weekDayDBEntity);
            }
        }
        return weekDayDBEntityList;
    }
}