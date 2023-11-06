package com.jeizard.scheduleapp.data.models.lessons.room.mapper;

import com.jeizard.scheduleapp.data.models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.domain.model.entities.Lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LessonDBEntityMapper implements Mapper<LessonDBEntity, Lesson> {

    public LessonDBEntityMapper() {
    }

    @Override
    public Lesson mapFromDBEntity(LessonDBEntity lessonDBEntity) {
        Lesson lesson = null;
        if (lessonDBEntity != null) {
            lesson = new Lesson(lessonDBEntity.getId(), lessonDBEntity.getStartTime(), lessonDBEntity.getEndTime());
        }
        return lesson;
    }

    @Override
    public LessonDBEntity mapToDBEntity(Lesson lesson) {
        LessonDBEntity lessonDBEntity = null;
        if (lesson != null) {
            lessonDBEntity = new LessonDBEntity(lesson.getId(), lesson.getStartTime(), lesson.getEndTime());
        }
        return lessonDBEntity;
    }

    @Override
    public List<Lesson> mapFromDBEntity(Collection<LessonDBEntity> lessonDBEntityCollection) {
        final List<Lesson> lessonList = new ArrayList<>();
        for (LessonDBEntity lessonDBEntity : lessonDBEntityCollection) {
            final Lesson lesson = mapFromDBEntity(lessonDBEntity);
            if (lesson != null) {
                lessonList.add(lesson);
            }
        }
        return lessonList;
    }

    @Override
    public List<LessonDBEntity> mapToDBEntity(Collection<Lesson> lessonCollection) {
        final List<LessonDBEntity> lessonDBEntityList = new ArrayList<>();
        for (Lesson lesson : lessonCollection) {
            final LessonDBEntity lessonDBEntity = mapToDBEntity(lesson);
            if (lessonDBEntity != null) {
                lessonDBEntityList.add(lessonDBEntity);
            }
        }
        return lessonDBEntityList;
    }
}