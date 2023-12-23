package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.types.room.entity.LessonTypeDBEntity;

@Entity(
        tableName = "lesson_types",
        primaryKeys = {"lesson_id", "type_id"},
        indices = {
                @Index("type_id")
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
                        entity = LessonTypeDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"type_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonTypesDBEntity {
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "type_id")
    private Long typeId;

    public LessonTypesDBEntity(@NonNull Long lessonId, @NonNull Long typeId) {
        this.lessonId = lessonId;
        this.typeId = typeId;
    }

    @NonNull
    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(@NonNull Long lessonId) {
        this.lessonId = lessonId;
    }

    @NonNull
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(@NonNull Long typeId) {
        this.typeId = typeId;
    }
}


