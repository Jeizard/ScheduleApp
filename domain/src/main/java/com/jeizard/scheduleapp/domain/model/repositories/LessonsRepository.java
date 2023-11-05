package com.jeizard.scheduleapp.domain.model.repositories;

import com.jeizard.scheduleapp.domain.model.entities.Lesson;

import java.util.List;

public interface LessonsRepository {
    void insert(Lesson lesson);

    void update(Lesson lesson);

    void delete(Lesson lesson);

    void deleteAllLessons();

    List<Lesson> getAllLessons();
}
