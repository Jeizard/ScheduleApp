package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.mapper;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.entity.LessonGroupsDBEntity;
import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.domain.model.entities.LessonGroups;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonGroupsDBEntityMapper implements Mapper<LessonGroupsDBEntity, LessonGroups> {

    public LessonGroupsDBEntityMapper() {
    }

    @Override
    public LessonGroups mapFromDBEntity(LessonGroupsDBEntity lessonGroupsDBEntity) {
        LessonGroups lessonGroups = null;
        if (lessonGroupsDBEntity != null) {
            lessonGroups = new LessonGroups(lessonGroupsDBEntity.getLessonId(), lessonGroupsDBEntity.getGroupId());
        }
        return lessonGroups;
    }

    @Override
    public LessonGroupsDBEntity mapToDBEntity(LessonGroups lessonGroups) {
        LessonGroupsDBEntity lessonGroupsDBEntity = null;
        if (lessonGroups != null) {
            lessonGroupsDBEntity = new LessonGroupsDBEntity(lessonGroups.getLesson_id(), lessonGroups.getGroup_id());
        }
        return lessonGroupsDBEntity;
    }

    @Override
    public List<LessonGroups> mapFromDBEntity(Collection<LessonGroupsDBEntity> lessonGroupsDBEntityCollection) {
        final List<LessonGroups> lessonGroupsList = new ArrayList<>();
        for (LessonGroupsDBEntity lessonGroupsDBEntity : lessonGroupsDBEntityCollection) {
            final LessonGroups lessonGroups = mapFromDBEntity(lessonGroupsDBEntity);
            if (lessonGroups != null) {
                lessonGroupsList.add(lessonGroups);
            }
        }
        return lessonGroupsList;
    }

    @Override
    public List<LessonGroupsDBEntity> mapToDBEntity(Collection<LessonGroups> lessonGroupsCollection) {
        final List<LessonGroupsDBEntity> lessonGroupsDBEntityList = new ArrayList<>();
        for (LessonGroups lessonGroups : lessonGroupsCollection) {
            final LessonGroupsDBEntity lessonGroupsDBEntity = mapToDBEntity(lessonGroups);
            if (lessonGroupsDBEntity != null) {
                lessonGroupsDBEntityList.add(lessonGroupsDBEntity);
            }
        }
        return lessonGroupsDBEntityList;
    }
}