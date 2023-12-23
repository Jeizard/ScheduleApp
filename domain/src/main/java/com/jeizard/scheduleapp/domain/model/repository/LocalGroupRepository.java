package com.jeizard.scheduleapp.domain.model.repository;

import com.jeizard.scheduleapp.domain.model.entities.Group;

import java.util.List;

public interface LocalGroupRepository {

    void insert(Group item, int userId);
    void update(Group item, int userId);
    void delete(Group item, int userId);
    void deleteAll();
    List<Group> getAll();

    interface OnDataChangedListener {
        void onChanged(List<Group> items);
    }

    void addListener(OnDataChangedListener listener);
    void removeListener(OnDataChangedListener listener);

    void reloadGroup(Group group, int userId);

    void createGroup(Group group, int userId);
    void uploadGroupsForCurrentUser(int userId);
}
