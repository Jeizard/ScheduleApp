package com.jeizard.scheduleapp.domain.model.entities;

public class LessonTeacher {
    private Long lessonId;
    private Long teacherId;

    public LessonTeacher(Long lessonId, Long teacherId) {
        this.lessonId = lessonId;
        this.teacherId = teacherId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
