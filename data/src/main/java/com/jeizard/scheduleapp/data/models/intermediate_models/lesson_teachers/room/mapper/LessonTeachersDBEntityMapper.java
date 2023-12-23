package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonTeacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonTeachersDBEntityMapper implements Mapper<LessonTeachersDBEntity, LessonTeacher> {

    public LessonTeachersDBEntityMapper() {
    }

    @Override
    public LessonTeacher mapFromDBEntity(LessonTeachersDBEntity lessonTeachersDBEntity) {
        LessonTeacher lessonTeachers = null;
        if (lessonTeachersDBEntity != null) {
            lessonTeachers = new LessonTeacher(lessonTeachersDBEntity.getLessonId(), lessonTeachersDBEntity.getTeacherId());
        }
        return lessonTeachers;
    }

    @Override
    public LessonTeachersDBEntity mapToDBEntity(LessonTeacher lessonTeachers) {
        LessonTeachersDBEntity lessonTeachersDBEntity = null;
        if (lessonTeachers != null) {
            lessonTeachersDBEntity = new LessonTeachersDBEntity(lessonTeachers.getLessonId(), lessonTeachers.getTeacherId());
        }
        return lessonTeachersDBEntity;
    }

    @Override
    public List<LessonTeacher> mapFromDBEntity(Collection<LessonTeachersDBEntity> lessonTeachersDBEntityCollection) {
        final List<LessonTeacher> lessonTeachersList = new ArrayList<>();
        for (LessonTeachersDBEntity lessonGroupsDBEntity : lessonTeachersDBEntityCollection) {
            final LessonTeacher lessonTeachers = mapFromDBEntity(lessonGroupsDBEntity);
            if (lessonTeachers != null) {
                lessonTeachersList.add(lessonTeachers);
            }
        }
        return lessonTeachersList;
    }

    @Override
    public List<LessonTeachersDBEntity> mapToDBEntity(Collection<LessonTeacher> lessonTeachersCollection) {
        final List<LessonTeachersDBEntity> lessonTeachersDBEntityList = new ArrayList<>();
        for (LessonTeacher lessonTeachers : lessonTeachersCollection) {
            final LessonTeachersDBEntity lessonTeachersDBEntity = mapToDBEntity(lessonTeachers);
            if (lessonTeachersDBEntity != null) {
                lessonTeachersDBEntityList.add(lessonTeachersDBEntity);
            }
        }
        return lessonTeachersDBEntityList;
    }
}