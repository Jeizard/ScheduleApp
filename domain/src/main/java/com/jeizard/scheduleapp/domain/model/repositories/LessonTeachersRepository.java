package com.jeizard.scheduleapp.domain.model.repositories;

import com.jeizard.scheduleapp.domain.model.entities.LessonTeachers;

import java.util.List;

public interface LessonTeachersRepository {
    void insert(LessonTeachers lessonTeachers);

    void update(LessonTeachers lessonTeachers);

    void delete(LessonTeachers lessonTeachers);

    void deleteAllLessonTeachers();

    List<LessonTeachers> getAllLessonTeachers();
}
