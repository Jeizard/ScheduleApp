package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;

@Entity(
        tableName = "lesson_subjects",
        primaryKeys = {"lesson_id", "subject_id"},
        indices = {
                @Index("subject_id")
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
                        entity = SubjectDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"subject_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonSubjectsDBEntity {
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "subject_id")
    private Long subjectId;

    public LessonSubjectsDBEntity(Long lessonId, Long subjectId) {
        this.lessonId = lessonId;
        this.subjectId = subjectId;
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


