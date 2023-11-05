package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repositories.GroupsRepository;

import java.util.List;

public class GetAllGroupsUseCase {
    private GroupsRepository groupsRepository;

    public GetAllGroupsUseCase(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public List<Group> execute(){
        return groupsRepository.getAllGroups();
    }
}
