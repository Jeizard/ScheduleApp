package com.jeizard.scheduleapp.domain.model.repository;

import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

import java.util.List;

public interface LessonWithWeekDayRepository {
    void setGroupNumber(String groupNumber);
    void insert(LessonWithFullInformation lessonWithWeekDay);

    void insertFromBDByGroup(String groupNumber);

    List<LessonWithFullInformation> getAll();

    interface OnDataChangedListener {
        void onChanged(List<LessonWithFullInformation> items);
    }

    void addListener(OnDataChangedListener listener);
    void removeListener(OnDataChangedListener listener);
}
