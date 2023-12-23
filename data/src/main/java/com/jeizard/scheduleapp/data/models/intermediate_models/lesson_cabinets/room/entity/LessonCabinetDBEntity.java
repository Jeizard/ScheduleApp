package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;

@Entity(
        tableName = "lesson_cabinets",
        primaryKeys = {"lesson_id", "cabinet_id"},
        indices = {
                @Index("cabinet_id")
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
                        entity = CabinetDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"cabinet_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonCabinetDBEntity {
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "cabinet_id")
    private Long cabinetId;

    public LessonCabinetDBEntity(@NonNull Long lessonId, @NonNull Long cabinetId) {
        this.lessonId = lessonId;
        this.cabinetId = cabinetId;
    }

    @NonNull
    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(@NonNull Long lessonId) {
        this.lessonId = lessonId;
    }

    @NonNull
    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(@NonNull Long cabinetId) {
        this.cabinetId = cabinetId;
    }
}


