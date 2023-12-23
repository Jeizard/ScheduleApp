package com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonsGroupsDBEntityMapper implements Mapper<LessonsGroupsDBEntity, LessonGroup> {

    public LessonsGroupsDBEntityMapper() {
    }

    @Override
    public LessonGroup mapFromDBEntity(LessonsGroupsDBEntity lessonGroupsDBEntity) {
        LessonGroup lessonGroups = null;
        if (lessonGroupsDBEntity != null) {
            lessonGroups = new LessonGroup(lessonGroupsDBEntity.getLessonId(), lessonGroupsDBEntity.getGroupId());
        }
        return lessonGroups;
    }

    @Override
    public LessonsGroupsDBEntity mapToDBEntity(LessonGroup lessonGroups) {
        LessonsGroupsDBEntity lessonGroupsDBEntity = null;
        if (lessonGroups != null) {
            lessonGroupsDBEntity = new LessonsGroupsDBEntity(lessonGroups.getLessonId(), lessonGroups.getGroupId());
        }
        return lessonGroupsDBEntity;
    }

    @Override
    public List<LessonGroup> mapFromDBEntity(Collection<LessonsGroupsDBEntity> lessonGroupsDBEntityCollection) {
        final List<LessonGroup> lessonGroupsList = new ArrayList<>();
        for (LessonsGroupsDBEntity lessonGroupsDBEntity : lessonGroupsDBEntityCollection) {
            final LessonGroup lessonGroups = mapFromDBEntity(lessonGroupsDBEntity);
            if (lessonGroups != null) {
                lessonGroupsList.add(lessonGroups);
            }
        }
        return lessonGroupsList;
    }

    @Override
    public List<LessonsGroupsDBEntity> mapToDBEntity(Collection<LessonGroup> lessonGroupsCollection) {
        final List<LessonsGroupsDBEntity> lessonGroupsDBEntityList = new ArrayList<>();
        for (LessonGroup lessonGroups : lessonGroupsCollection) {
            final LessonsGroupsDBEntity lessonGroupsDBEntity = mapToDBEntity(lessonGroups);
            if (lessonGroupsDBEntity != null) {
                lessonGroupsDBEntityList.add(lessonGroupsDBEntity);
            }
        }
        return lessonGroupsDBEntityList;
    }
}