package com.jeizard.scheduleapp.domain.model.entities;

public class LessonSubject {
    private Long lessonId;
    private Long subjectId;

    public LessonSubject(Long lesson_id, Long subject_id) {
        this.lessonId = lesson_id;
        this.subjectId = subject_id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
