package com.jeizard.scheduleapp.domain.model.entities;


public class LessonTypes {
    private Long lessonId;
    private Long typeId;

    public LessonTypes(Long lessonId, Long typeId) {
        this.lessonId = lessonId;
        this.typeId = typeId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
