package com.jeizard.scheduleapp.domain.model.entities;

public class LessonGroups {
    public int lesson_id;
    public int group_id;

    public LessonGroups(int lesson_id, int group_id) {
        this.lesson_id = lesson_id;
        this.group_id = group_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}
