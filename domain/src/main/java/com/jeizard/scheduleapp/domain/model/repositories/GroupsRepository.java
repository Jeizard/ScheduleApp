package com.jeizard.scheduleapp.domain.model.repositories;

import com.jeizard.scheduleapp.domain.model.entities.Group;

import java.util.List;

public interface GroupsRepository {
    void insert(Group group);

    void update(Group group);

    void delete(Group group);

    public void deleteAllGroups();

    List<Group> getAllGroups();
}
