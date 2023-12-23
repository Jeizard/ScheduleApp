package com.jeizard.scheduleapp.domain.model.repository;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

import java.util.List;

public interface GroupRepository extends BaseRepository<Group> {

    void createCopy(Group group, int userId);

    interface CopyGroupListener {
        void onChanged(int groupId);
    }

    void addCopyGroupListener(CopyGroupListener listener);
    void removeCopyGroupListener(CopyGroupListener listener);
}
