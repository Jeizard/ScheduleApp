package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;

public class UploadLocalGroupToGlobalGroupsUseCase {
    private GroupRepository groupsRepository;

    public UploadLocalGroupToGlobalGroupsUseCase(GroupRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public void execute(Group group){
        groupsRepository.update(group);

    }
}
