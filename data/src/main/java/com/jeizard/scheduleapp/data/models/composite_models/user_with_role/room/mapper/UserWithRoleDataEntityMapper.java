package com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.entity.UserWithRoleDataEntity;
import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserWithRoleDataEntityMapper implements Mapper<UserWithRoleDataEntity, UserWithRole> {

    public UserWithRoleDataEntityMapper() {
    }

    @Override
    public UserWithRole mapFromDBEntity(UserWithRoleDataEntity userWithRoleDataEntity) {
        UserWithRole userWithRole = null;
        if (userWithRoleDataEntity != null) {
            userWithRole = new UserWithRole(userWithRoleDataEntity.getId(),
                    userWithRoleDataEntity.getEmail(),
                    userWithRoleDataEntity.getRole());
        }
        return userWithRole;
    }

    @Override
    public UserWithRoleDataEntity mapToDBEntity(UserWithRole userWithRole) {
        UserWithRoleDataEntity userWithRoleDataEntity = null;
        if (userWithRole != null) {
            userWithRoleDataEntity = new UserWithRoleDataEntity(userWithRole.getId(),
                    userWithRole.getEmail(),
                    userWithRole.getRole());
        }
        return userWithRoleDataEntity;
    }

    @Override
    public List<UserWithRole> mapFromDBEntity(Collection<UserWithRoleDataEntity> userWithRoleDataEntityCollection) {
        final List<UserWithRole> userWithRoleList = new ArrayList<>();
        for (UserWithRoleDataEntity userWithRoleDataEntity : userWithRoleDataEntityCollection) {
            final UserWithRole userWithRole = mapFromDBEntity(userWithRoleDataEntity);
            if (userWithRole != null) {
                userWithRoleList.add(userWithRole);
            }
        }
        return userWithRoleList;
    }

    @Override
    public List<UserWithRoleDataEntity> mapToDBEntity(Collection<UserWithRole> userWithRoleCollection) {
        final List<UserWithRoleDataEntity> userWithRoleDataEntityList = new ArrayList<>();
        for (UserWithRole userWithRole : userWithRoleCollection) {
            final UserWithRoleDataEntity userWithRoleDataEntity = mapToDBEntity(userWithRole);
            if (userWithRoleDataEntity != null) {
                userWithRoleDataEntityList.add(userWithRoleDataEntity);
            }
        }
        return userWithRoleDataEntityList;
    }
}