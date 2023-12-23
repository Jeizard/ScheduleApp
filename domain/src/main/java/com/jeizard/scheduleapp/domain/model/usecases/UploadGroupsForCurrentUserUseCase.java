package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

public class UploadGroupsForCurrentUserUseCase {
    private LocalGroupRepository groupsRepository;

    public UploadGroupsForCurrentUserUseCase(LocalGroupRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    public void execute(int userId){
        groupsRepository.uploadGroupsForCurrentUser(userId);
    }
}
