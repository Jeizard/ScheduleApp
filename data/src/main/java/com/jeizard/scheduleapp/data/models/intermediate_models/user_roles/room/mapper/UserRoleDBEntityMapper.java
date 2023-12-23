package com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity.UserRoleDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.LessonWeekDay;
import com.jeizard.scheduleapp.domain.model.entities.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRoleDBEntityMapper implements Mapper<UserRoleDBEntity, UserRole> {

    public UserRoleDBEntityMapper() {
    }

    @Override
    public UserRole mapFromDBEntity(UserRoleDBEntity userRoleDBEntity) {
        UserRole userRole = null;
        if (userRoleDBEntity != null) {
            userRole = new UserRole(userRoleDBEntity.getUserId(), userRoleDBEntity.getRoleId());
        }
        return userRole;
    }

    @Override
    public UserRoleDBEntity mapToDBEntity(UserRole userRole) {
        UserRoleDBEntity userRoleDBEntity = null;
        if (userRole != null) {
            userRoleDBEntity = new UserRoleDBEntity(userRole.getUserId(), userRole.getRoleId());
        }
        return userRoleDBEntity;
    }

    @Override
    public List<UserRole> mapFromDBEntity(Collection<UserRoleDBEntity> userRoleDBEntityCollection) {
        final List<UserRole> userRoleList = new ArrayList<>();
        for (UserRoleDBEntity userRoleDBEntity : userRoleDBEntityCollection) {
            final UserRole userRole = mapFromDBEntity(userRoleDBEntity);
            if (userRole != null) {
                userRoleList.add(userRole);
            }
        }
        return userRoleList;
    }

    @Override
    public List<UserRoleDBEntity> mapToDBEntity(Collection<UserRole> userRoleCollection) {
        final List<UserRoleDBEntity> userRoleDBEntityList = new ArrayList<>();
        for (UserRole userRole : userRoleCollection) {
            final UserRoleDBEntity userRoleDBEntity = mapToDBEntity(userRole);
            if (userRoleDBEntity != null) {
                userRoleDBEntityList.add(userRoleDBEntity);
            }
        }
        return userRoleDBEntityList;
    }
}