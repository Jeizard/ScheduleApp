package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;
import com.jeizard.scheduleapp.domain.model.repository.LessonWithWeekDayRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

public class AddGroupToListFollowedUseCase {
    private Group group;
    private LocalGroupRepository groupsRepository;

    public AddGroupToListFollowedUseCase(Group group, LocalGroupRepository groupsRepository) {
        this.group = group;
        this.groupsRepository = groupsRepository;
    }

    public void execute(int userId){
        groupsRepository.insert(group, userId);
    }
}
