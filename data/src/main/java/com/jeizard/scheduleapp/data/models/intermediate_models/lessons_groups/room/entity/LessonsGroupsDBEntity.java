package com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;

@Entity(
        tableName = "lessons_groups",
        primaryKeys = {"lesson_id", "group_id"},
        indices = {
                @Index("group_id")
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
                        entity = GroupDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"group_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonsGroupsDBEntity {
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "group_id")
    private Long groupId;

    public LessonsGroupsDBEntity(Long lessonId, Long groupId) {
        this.lessonId = lessonId;
        this.groupId = groupId;
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


