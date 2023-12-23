package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity.LessonCabinetDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonCabinet;
import com.jeizard.scheduleapp.domain.model.entities.LessonSubject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonCabinetDBEntityMapper implements Mapper<LessonCabinetDBEntity, LessonCabinet> {

    public LessonCabinetDBEntityMapper() {
    }

    @Override
    public LessonCabinet mapFromDBEntity(LessonCabinetDBEntity lessonCabinetDBEntity) {
        LessonCabinet lessonCabinet = null;
        if (lessonCabinetDBEntity != null) {
            lessonCabinet = new LessonCabinet(lessonCabinetDBEntity.getLessonId(), lessonCabinetDBEntity.getCabinetId());
        }
        return lessonCabinet;
    }

    @Override
    public LessonCabinetDBEntity mapToDBEntity(LessonCabinet lessonCabinet) {
        LessonCabinetDBEntity lessonCabinetDBEntity = null;
        if (lessonCabinet != null) {
            lessonCabinetDBEntity = new LessonCabinetDBEntity(lessonCabinet.getLessonId(), lessonCabinet.getCabinetId());
        }
        return lessonCabinetDBEntity;
    }

    @Override
    public List<LessonCabinet> mapFromDBEntity(Collection<LessonCabinetDBEntity> lessonCabinetDBEntityCollection) {
        final List<LessonCabinet> lessonCabinetList = new ArrayList<>();
        for (LessonCabinetDBEntity lessonCabinetDBEntity : lessonCabinetDBEntityCollection) {
            final LessonCabinet lessonCabinet = mapFromDBEntity(lessonCabinetDBEntity);
            if (lessonCabinet != null) {
                lessonCabinetList.add(lessonCabinet);
            }
        }
        return lessonCabinetList;
    }

    @Override
    public List<LessonCabinetDBEntity> mapToDBEntity(Collection<LessonCabinet> lessonCabinetCollection) {
        final List<LessonCabinetDBEntity> lessonCabinetDBEntityList = new ArrayList<>();
        for (LessonCabinet lessonCabinet : lessonCabinetCollection) {
            final LessonCabinetDBEntity lessonCabinetDBEntity = mapToDBEntity(lessonCabinet);
            if (lessonCabinetDBEntity != null) {
                lessonCabinetDBEntityList.add(lessonCabinetDBEntity);
            }
        }
        return lessonCabinetDBEntityList;
    }
}