package com.jeizard.scheduleapp.domain.model.repositories;

import com.jeizard.scheduleapp.domain.model.entities.LessonGroups;

import java.util.List;

public interface LessonGroupsRepository {
    void insert(LessonGroups lessonGroup);

    void update(LessonGroups lessonGroup);

    void delete(LessonGroups lessonGroup);

    void deleteAllLessonGroups();

    List<LessonGroups> getAllLessonGroups();
}
