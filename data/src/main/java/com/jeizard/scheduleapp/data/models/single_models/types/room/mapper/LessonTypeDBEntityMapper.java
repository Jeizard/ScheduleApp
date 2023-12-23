package com.jeizard.scheduleapp.data.models.single_models.types.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.types.room.entity.LessonTypeDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonTypeDBEntityMapper implements Mapper<LessonTypeDBEntity, LessonType> {

    public LessonTypeDBEntityMapper() {
    }

    @Override
    public LessonType mapFromDBEntity(LessonTypeDBEntity lessonTypeDBEntity) {
        LessonType lessonType = null;
        if (lessonTypeDBEntity != null) {
            lessonType = new LessonType(lessonTypeDBEntity.getId(), lessonTypeDBEntity.getTitle(), lessonTypeDBEntity.getAbbreviation());
        }
        return lessonType;
    }

    @Override
    public LessonTypeDBEntity mapToDBEntity(LessonType lessonType) {
        LessonTypeDBEntity lessonTypeDBEntity = null;
        if (lessonType != null) {
            lessonTypeDBEntity = new LessonTypeDBEntity(lessonType.getId(), lessonType.getTitle(), lessonType.getAbbreviation());
        }
        return lessonTypeDBEntity;
    }

    @Override
    public List<LessonType> mapFromDBEntity(Collection<LessonTypeDBEntity> lessonTypeDBEntityCollection) {
        final List<LessonType> lessonTypeList = new ArrayList<>();
        for (LessonTypeDBEntity lessonTypeDBEntity : lessonTypeDBEntityCollection) {
            final LessonType lessonType = mapFromDBEntity(lessonTypeDBEntity);
            if (lessonType != null) {
                lessonTypeList.add(lessonType);
            }
        }
        return lessonTypeList;
    }

    @Override
    public List<LessonTypeDBEntity> mapToDBEntity(Collection<LessonType> lessonTypeCollection) {
        final List<LessonTypeDBEntity> lessonTypeDBEntityList = new ArrayList<>();
        for (LessonType lessonType : lessonTypeCollection) {
            final LessonTypeDBEntity lessonTypeDBEntity = mapToDBEntity(lessonType);
            if (lessonTypeDBEntity != null) {
                lessonTypeDBEntityList.add(lessonTypeDBEntity);
            }
        }
        return lessonTypeDBEntityList;
    }
}