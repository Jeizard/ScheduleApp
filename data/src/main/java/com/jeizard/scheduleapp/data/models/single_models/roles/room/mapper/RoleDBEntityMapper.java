package com.jeizard.scheduleapp.data.models.single_models.roles.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Role;
import com.jeizard.scheduleapp.domain.model.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoleDBEntityMapper implements Mapper<RoleDBEntity, Role> {

    public RoleDBEntityMapper() {
    }

    @Override
    public Role mapFromDBEntity(RoleDBEntity roleDBEntity) {
        Role role = null;
        if (roleDBEntity != null) {
            role = new Role(roleDBEntity.getId(), roleDBEntity.getName());
        }
        return role;
    }

    @Override
    public RoleDBEntity mapToDBEntity(Role role) {
        RoleDBEntity roleDBEntity = null;
        if (role != null) {
            roleDBEntity = new RoleDBEntity(role.getId(), role.getName());
        }
        return roleDBEntity;
    }

    @Override
    public List<Role> mapFromDBEntity(Collection<RoleDBEntity> roleDBEntityCollection) {
        final List<Role> roleList = new ArrayList<>();
        for (RoleDBEntity roleDBEntity : roleDBEntityCollection) {
            final Role role = mapFromDBEntity(roleDBEntity);
            if (role != null) {
                roleList.add(role);
            }
        }
        return roleList;
    }

    @Override
    public List<RoleDBEntity> mapToDBEntity(Collection<Role> roleCollection) {
        final List<RoleDBEntity> roleDBEntityList = new ArrayList<>();
        for (Role role : roleCollection) {
            final RoleDBEntity roleDBEntity = mapToDBEntity(role);
            if (roleDBEntity != null) {
                roleDBEntityList.add(roleDBEntity);
            }
        }
        return roleDBEntityList;
    }
}