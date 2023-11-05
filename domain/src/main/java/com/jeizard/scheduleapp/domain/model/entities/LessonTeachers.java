package com.jeizard.scheduleapp.domain.model.entities;

public class LessonTeachers {
    public int lesson_id;
    public int teacher_id;

    public LessonTeachers(int lesson_id, int teacher_id) {
        this.lesson_id = lesson_id;
        this.teacher_id = teacher_id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
