package com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.UserGroup;
import com.jeizard.scheduleapp.domain.model.entities.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserGroupDBEntityMapper implements Mapper<UserGroupDBEntity, UserGroup> {

    public UserGroupDBEntityMapper() {
    }

    @Override
    public UserGroup mapFromDBEntity(UserGroupDBEntity userGroupDBEntity) {
        UserGroup userGroup = null;
        if (userGroupDBEntity != null) {
            userGroup = new UserGroup(userGroupDBEntity.getUserId(), userGroupDBEntity.getGroupId());
        }
        return userGroup;
    }

    @Override
    public UserGroupDBEntity mapToDBEntity(UserGroup userGroup) {
        UserGroupDBEntity userGroupDBEntity = null;
        if (userGroup != null) {
            userGroupDBEntity = new UserGroupDBEntity(userGroup.getUserId(), userGroup.getGroupId());
        }
        return userGroupDBEntity;
    }

    @Override
    public List<UserGroup> mapFromDBEntity(Collection<UserGroupDBEntity> userGroupDBEntityCollection) {
        final List<UserGroup> userGroupList = new ArrayList<>();
        for (UserGroupDBEntity userGroupDBEntity : userGroupDBEntityCollection) {
            final UserGroup userGroup = mapFromDBEntity(userGroupDBEntity);
            if (userGroup != null) {
                userGroupList.add(userGroup);
            }
        }
        return userGroupList;
    }

    @Override
    public List<UserGroupDBEntity> mapToDBEntity(Collection<UserGroup> userGroupCollection) {
        final List<UserGroupDBEntity> userGroupDBEntityList = new ArrayList<>();
        for (UserGroup userGroup : userGroupCollection) {
            final UserGroupDBEntity userGroupDBEntity = mapToDBEntity(userGroup);
            if (userGroupDBEntity != null) {
                userGroupDBEntityList.add(userGroupDBEntity);
            }
        }
        return userGroupDBEntityList;
    }
}