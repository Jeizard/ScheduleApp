package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity.LessonTypesDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonSubject;
import com.jeizard.scheduleapp.domain.model.entities.LessonTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonTypesDBEntityMapper implements Mapper<LessonTypesDBEntity, LessonTypes> {

    public LessonTypesDBEntityMapper() {
    }

    @Override
    public LessonTypes mapFromDBEntity(LessonTypesDBEntity lessonTypesDBEntity) {
        LessonTypes lessonTypes = null;
        if (lessonTypesDBEntity != null) {
            lessonTypes = new LessonTypes(lessonTypesDBEntity.getLessonId(), lessonTypesDBEntity.getTypeId());
        }
        return lessonTypes;
    }

    @Override
    public LessonTypesDBEntity mapToDBEntity(LessonTypes lessonTypes) {
        LessonTypesDBEntity lessonTypesDBEntity = null;
        if (lessonTypes != null) {
            lessonTypesDBEntity = new LessonTypesDBEntity(lessonTypes.getLessonId(), lessonTypes.getTypeId());
        }
        return lessonTypesDBEntity;
    }

    @Override
    public List<LessonTypes> mapFromDBEntity(Collection<LessonTypesDBEntity> lessonTypesDBEntityCollection) {
        final List<LessonTypes> lessonTypesList = new ArrayList<>();
        for (LessonTypesDBEntity lessonTypesDBEntity : lessonTypesDBEntityCollection) {
            final LessonTypes lessonTypes = mapFromDBEntity(lessonTypesDBEntity);
            if (lessonTypes != null) {
                lessonTypesList.add(lessonTypes);
            }
        }
        return lessonTypesList;
    }

    @Override
    public List<LessonTypesDBEntity> mapToDBEntity(Collection<LessonTypes> lessonTypesCollection) {
        final List<LessonTypesDBEntity> lessonTypesDBEntityList = new ArrayList<>();
        for (LessonTypes lessonTypes : lessonTypesCollection) {
            final LessonTypesDBEntity lessonTypesDBEntity = mapToDBEntity(lessonTypes);
            if (lessonTypesDBEntity != null) {
                lessonTypesDBEntityList.add(lessonTypesDBEntity);
            }
        }
        return lessonTypesDBEntityList;
    }
}