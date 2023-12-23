package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

public class CreateGroupScheduleUseCase {

    private LocalGroupRepository localGroupRepository;

    public CreateGroupScheduleUseCase(LocalGroupRepository localGroupRepository) {
        this.localGroupRepository = localGroupRepository;
    }

    public void execute(Group group, int userId){
        localGroupRepository.createGroup(group, userId);
    }
}
