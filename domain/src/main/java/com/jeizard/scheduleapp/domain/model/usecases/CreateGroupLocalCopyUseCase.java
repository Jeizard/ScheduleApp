package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;

public class CreateGroupLocalCopyUseCase {
    private Group group;
    private GroupRepository groupsRepository;

    public CreateGroupLocalCopyUseCase(Group group, GroupRepository groupsRepository) {
        this.group = group;
        this.groupsRepository = groupsRepository;
    }

    public void execute(int userId){
        groupsRepository.createCopy(group, userId);
    }
}
