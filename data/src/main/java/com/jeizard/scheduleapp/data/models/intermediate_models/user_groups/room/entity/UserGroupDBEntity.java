package com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;

@Entity(
        tableName = "user_groups",
        primaryKeys = {"user_id", "group_id"},
        indices = {
                @Index("group_id")
        },
        foreignKeys = {
                @ForeignKey(
                        entity = UserDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"user_id"},
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
public class UserGroupDBEntity {
    @NonNull
    @ColumnInfo(name = "user_id")
    private Long userId;
    @NonNull
    @ColumnInfo(name = "group_id")
    private Long groupId;

    public UserGroupDBEntity(@NonNull Long userId, @NonNull Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    @NonNull
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(@NonNull Long groupId) {
        this.groupId = groupId;
    }
}


