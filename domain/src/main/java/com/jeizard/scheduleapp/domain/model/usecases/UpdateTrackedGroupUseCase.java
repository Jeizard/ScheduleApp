package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

public class UpdateTrackedGroupUseCase {

    private LocalGroupRepository localGroupRepository;

    public UpdateTrackedGroupUseCase(LocalGroupRepository localGroupRepository) {
        this.localGroupRepository = localGroupRepository;
    }

    public void execute(Group group, int userId){
        localGroupRepository.update(group, userId);
    }
}
