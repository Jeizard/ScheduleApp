package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.lessons.room.entity.LessonDBEntity;

@Entity(
        tableName = "lesson_groups",
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
public class LessonGroupsDBEntity {
    @ColumnInfo(name = "lesson_id")
    public int lessonId;
    @ColumnInfo(name = "group_id")
    public int groupId;

    public LessonGroupsDBEntity(int lessonId, int groupId) {
        this.lessonId = lessonId;
        this.groupId = groupId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}


