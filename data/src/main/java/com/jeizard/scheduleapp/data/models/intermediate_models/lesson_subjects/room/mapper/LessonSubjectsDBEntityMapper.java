package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonSubject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonSubjectsDBEntityMapper implements Mapper<LessonSubjectsDBEntity, LessonSubject> {

    public LessonSubjectsDBEntityMapper() {
    }

    @Override
    public LessonSubject mapFromDBEntity(LessonSubjectsDBEntity lessonSubjectsDBEntity) {
        LessonSubject lessonsSubjects = null;
        if (lessonSubjectsDBEntity != null) {
            lessonsSubjects = new LessonSubject(lessonSubjectsDBEntity.getLessonId(), lessonSubjectsDBEntity.getSubjectId());
        }
        return lessonsSubjects;
    }

    @Override
    public LessonSubjectsDBEntity mapToDBEntity(LessonSubject lessonsSubjects) {
        LessonSubjectsDBEntity lessonSubjectsDBEntity = null;
        if (lessonsSubjects != null) {
            lessonSubjectsDBEntity = new LessonSubjectsDBEntity(lessonsSubjects.getLessonId(), lessonsSubjects.getSubjectId());
        }
        return lessonSubjectsDBEntity;
    }

    @Override
    public List<LessonSubject> mapFromDBEntity(Collection<LessonSubjectsDBEntity> lessonSubjectsDBEntityCollection) {
        final List<LessonSubject> lessonsSubjectsList = new ArrayList<>();
        for (LessonSubjectsDBEntity lessonSubjectsDBEntity : lessonSubjectsDBEntityCollection) {
            final LessonSubject lessonsSubjects = mapFromDBEntity(lessonSubjectsDBEntity);
            if (lessonsSubjects != null) {
                lessonsSubjectsList.add(lessonsSubjects);
            }
        }
        return lessonsSubjectsList;
    }

    @Override
    public List<LessonSubjectsDBEntity> mapToDBEntity(Collection<LessonSubject> lessonsSubjectsCollection) {
        final List<LessonSubjectsDBEntity> lessonSubjectsDBEntityList = new ArrayList<>();
        for (LessonSubject lessonsSubjects : lessonsSubjectsCollection) {
            final LessonSubjectsDBEntity lessonSubjectsDBEntity = mapToDBEntity(lessonsSubjects);
            if (lessonSubjectsDBEntity != null) {
                lessonSubjectsDBEntityList.add(lessonSubjectsDBEntity);
            }
        }
        return lessonSubjectsDBEntityList;
    }
}