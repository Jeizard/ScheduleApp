package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;

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
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "teacher_id")
    private Long teacherId;

    public LessonTeachersDBEntity(Long lessonId, Long teacherId) {
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


