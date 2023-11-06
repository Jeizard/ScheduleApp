package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonTeachers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonTeachersDBEntityMapper implements Mapper<LessonTeachersDBEntity, LessonTeachers> {

    public LessonTeachersDBEntityMapper() {
    }

    @Override
    public LessonTeachers mapFromDBEntity(LessonTeachersDBEntity lessonTeachersDBEntity) {
        LessonTeachers lessonTeachers = null;
        if (lessonTeachersDBEntity != null) {
            lessonTeachers = new LessonTeachers(lessonTeachersDBEntity.getLessonId(), lessonTeachersDBEntity.getTeacher_id());
        }
        return lessonTeachers;
    }

    @Override
    public LessonTeachersDBEntity mapToDBEntity(LessonTeachers lessonTeachers) {
        LessonTeachersDBEntity lessonTeachersDBEntity = null;
        if (lessonTeachers != null) {
            lessonTeachersDBEntity = new LessonTeachersDBEntity(lessonTeachers.getLesson_id(), lessonTeachers.getTeacher_id());
        }
        return lessonTeachersDBEntity;
    }

    @Override
    public List<LessonTeachers> mapFromDBEntity(Collection<LessonTeachersDBEntity> lessonTeachersDBEntityCollection) {
        final List<LessonTeachers> lessonTeachersList = new ArrayList<>();
        for (LessonTeachersDBEntity lessonGroupsDBEntity : lessonTeachersDBEntityCollection) {
            final LessonTeachers lessonTeachers = mapFromDBEntity(lessonGroupsDBEntity);
            if (lessonTeachers != null) {
                lessonTeachersList.add(lessonTeachers);
            }
        }
        return lessonTeachersList;
    }

    @Override
    public List<LessonTeachersDBEntity> mapToDBEntity(Collection<LessonTeachers> lessonTeachersCollection) {
        final List<LessonTeachersDBEntity> lessonTeachersDBEntityList = new ArrayList<>();
        for (LessonTeachers lessonTeachers : lessonTeachersCollection) {
            final LessonTeachersDBEntity lessonTeachersDBEntity = mapToDBEntity(lessonTeachers);
            if (lessonTeachersDBEntity != null) {
                lessonTeachersDBEntityList.add(lessonTeachersDBEntity);
            }
        }
        return lessonTeachersDBEntityList;
    }
}