package com.jeizard.scheduleapp.domain.model.entities;

public class LessonGroup {
    private Long lessonId;
    private Long groupId;

    public LessonGroup(Long lesson_id, Long group_id) {
        this.lessonId = lesson_id;
        this.groupId = group_id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
