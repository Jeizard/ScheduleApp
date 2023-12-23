package com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;

@Entity(
        tableName = "user_roles",
        primaryKeys = {"user_id", "role_id"},
        indices = {
                @Index("role_id")
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
                        entity = RoleDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"role_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class UserRoleDBEntity {
    @NonNull
    @ColumnInfo(name = "user_id")
    private Long userId;
    @NonNull
    @ColumnInfo(name = "role_id")
    private Long roleId;

    public UserRoleDBEntity(@NonNull Long userId, @NonNull Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    @NonNull
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(@NonNull Long roleId) {
        this.roleId = roleId;
    }
}


