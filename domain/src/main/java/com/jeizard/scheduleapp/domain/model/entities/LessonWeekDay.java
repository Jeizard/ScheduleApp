package com.jeizard.scheduleapp.domain.model.entities;

public class LessonWeekDay {
    private Long lessonId;
    private Long weekdayId;

    public LessonWeekDay(Long lessonId, Long weekdayId) {
        this.lessonId = lessonId;
        this.weekdayId = weekdayId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getWeekdayId() {
        return weekdayId;
    }

    public void setWeekdayId(Long weekdayId) {
        this.weekdayId = weekdayId;
    }
}
