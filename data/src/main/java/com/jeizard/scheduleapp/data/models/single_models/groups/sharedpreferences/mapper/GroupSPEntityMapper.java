package com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.entity.GroupSPEntity;
import com.jeizard.scheduleapp.domain.model.entities.Group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GroupSPEntityMapper implements Mapper<GroupSPEntity, Group> {

    public GroupSPEntityMapper() {
    }

    @Override
    public Group mapFromDBEntity(GroupSPEntity groupSPEntity) {
        Group group = null;
        if (groupSPEntity != null) {
            group = new Group(groupSPEntity.getId(), groupSPEntity.getNumber(), groupSPEntity.getLocal());
        }
        return group;
    }

    @Override
    public GroupSPEntity mapToDBEntity(Group group) {
        GroupSPEntity groupSPEntity = null;
        if (group != null) {
            groupSPEntity = new GroupSPEntity(group.getId(), group.getNumber(), group.getLocal());
        }
        return groupSPEntity;
    }

    @Override
    public List<Group> mapFromDBEntity(Collection<GroupSPEntity> groupSPEntityCollection) {
        final List<Group> groupList = new ArrayList<>();
        for (GroupSPEntity groupSPEntity : groupSPEntityCollection) {
            final Group group = mapFromDBEntity(groupSPEntity);
            if (group != null) {
                groupList.add(group);
            }
        }
        return groupList;
    }

    @Override
    public List<GroupSPEntity> mapToDBEntity(Collection<Group> groupCollection) {
        final List<GroupSPEntity> groupSPEntityList = new ArrayList<>();
        for (Group group : groupCollection) {
            final GroupSPEntity groupSPEntity = mapToDBEntity(group);
            if (groupSPEntity != null) {
                groupSPEntityList.add(groupSPEntity);
            }
        }
        return groupSPEntityList;
    }
}