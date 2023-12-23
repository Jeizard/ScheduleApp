package com.jeizard.scheduleapp.presentation.ActionListeners;

import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

public interface LessonActionListener {
    void onLessonSelected(LessonWithFullInformation lesson);
}
