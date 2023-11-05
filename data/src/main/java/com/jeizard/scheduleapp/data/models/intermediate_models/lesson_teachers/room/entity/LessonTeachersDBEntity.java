package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.teachers.room.entity.TeacherDBEntity;

@Entity(
        tableName = "lesson_teachers",
        primaryKeys = {"lesson_id", "teacher_id"},
        indices = {
                @Index("teacher_id")
        },
        foreignKeys = {
                @ForeignKey(
                        entity = LessonDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"lesson_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = TeacherDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"teacher_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonTeachersDBEntity {
    @ColumnInfo(name = "lesson_id")
    public int lessonId;
    @ColumnInfo(name = "teacher_id")
    public int teacher_id;

    public LessonTeachersDBEntity(int lessonId, int teacher_id) {
        this.lessonId = lessonId;
        this.teacher_id = teacher_id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}


