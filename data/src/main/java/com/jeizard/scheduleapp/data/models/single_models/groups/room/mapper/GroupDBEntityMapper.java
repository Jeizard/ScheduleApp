package com.jeizard.scheduleapp.data.models.single_models.groups.room.mapper;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.domain.model.entities.Group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupDBEntityMapper implements Mapper<GroupDBEntity, Group> {

    public GroupDBEntityMapper() {
    }

    @Override
    public Group mapFromDBEntity(GroupDBEntity groupDBEntity) {
        Group group = null;
        if (groupDBEntity != null) {
            group = new Group(groupDBEntity.getId(), groupDBEntity.getNumber(), groupDBEntity.getLocal());
        }
        return group;
    }

    @Override
    public GroupDBEntity mapToDBEntity(Group group) {
        GroupDBEntity groupDBEntity = null;
        if (group != null) {
            groupDBEntity = new GroupDBEntity(group.getId(), group.getNumber(), group.getLocal());
        }
        return groupDBEntity;
    }

    @Override
    public List<Group> mapFromDBEntity(Collection<GroupDBEntity> groupDBEntityCollection) {
        final List<Group> groupList = new ArrayList<>();
        for (GroupDBEntity groupDBEntity : groupDBEntityCollection) {
            final Group group = mapFromDBEntity(groupDBEntity);
            if (group != null) {
                groupList.add(group);
            }
        }
        return groupList;
    }

    @Override
    public List<GroupDBEntity> mapToDBEntity(Collection<Group> groupCollection) {
        final List<GroupDBEntity> groupDBEntityList = new ArrayList<>();
        for (Group group : groupCollection) {
            final GroupDBEntity groupDBEntity = mapToDBEntity(group);
            if (groupDBEntity != null) {
                groupDBEntityList.add(groupDBEntity);
            }
        }
        return groupDBEntityList;
    }
}