package com.jeizard.scheduleapp.domain.model.repository;

import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

import java.util.List;

public interface LessonsWithFullInformationRepository extends BaseRepository<LessonWithFullInformation> {
    void getLessonsByGroup(int groupId);
    void insertLessonsByGroup(LessonWithFullInformation lesson, int groupId);

    void deleteLessonForLocalGroup(int lessonId, int groupId);
    interface LessonsByGroupListener {
        void onChanged(List<LessonWithFullInformation> items);
    }

    void addLessonsByGroupListener(LessonsByGroupListener listener);
    void removeLessonsByGroupListener(LessonsByGroupListener listener);
}