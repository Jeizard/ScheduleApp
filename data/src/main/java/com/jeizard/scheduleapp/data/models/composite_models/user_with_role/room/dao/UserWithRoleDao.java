package com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.entity.UserWithRoleDataEntity;

import java.util.List;

@Dao
public abstract class UserWithRoleDao {

    @Query("SELECT " +
            "users.id, " +
            "users.email, " +
            "roles.name AS role " +
            "FROM users " +
            "LEFT JOIN user_roles ON users.id = user_roles.user_id " +
            "LEFT JOIN roles ON roles.id = user_roles.role_id")
    public abstract List<UserWithRoleDataEntity> getAllUsersWithRole();
}
