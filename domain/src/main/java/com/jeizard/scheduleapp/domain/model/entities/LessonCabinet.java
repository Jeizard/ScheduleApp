package com.jeizard.scheduleapp.domain.model.entities;

public class LessonCabinet {
    private Long lessonId;
    private Long cabinetId;

    public LessonCabinet(Long lessonId, Long cabinetId) {
        this.lessonId = lessonId;
        this.cabinetId = cabinetId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }
}
