package com.jeizard.scheduleapp.presentation.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

import java.util.List;

public class DailyScheduleViewModel extends ViewModel {
    private LessonsWithFullInformationRepository lessonsWithFullInformationRepository;
    private LocalGroupRepository groupsRepository;
    private BaseRepository<UserWithRole> userWithRoleRepository;
    public MutableLiveData<List<Group>> trackedGroups = new MutableLiveData<List<Group>>();
    public MutableLiveData<Group> selectedGroup = new MutableLiveData<Group>(new Group());
    public MutableLiveData<List<UserWithRole>> users = new MutableLiveData<List<UserWithRole>>();
    public MutableLiveData<List<LessonWithFullInformation>> allLessonsWithFullInformationForSelectedGroup = new MutableLiveData<List<LessonWithFullInformation>>();
    public DailyScheduleViewModel(LocalGroupRepository groupsRepository, LessonsWithFullInformationRepository lessonsWithFullInformationRepository, BaseRepository<UserWithRole> userWithRoleRepository) {
        this.groupsRepository = groupsRepository;
        this.lessonsWithFullInformationRepository = lessonsWithFullInformationRepository;
        this.userWithRoleRepository = userWithRoleRepository;
        loadAllTrackedGroups();
        loadAllLessonsWithFullInformationForSelectedGroup();
        loadAllUsersWithRole();
    }


    public LessonsWithFullInformationRepository getLessonsWithFullInformationRepository() {
        return lessonsWithFullInformationRepository;
    }

    public void setSelectedGroup(Group selectedGroup) {
        this.selectedGroup.setValue(selectedGroup);
        lessonsWithFullInformationRepository.getLessonsByGroup(selectedGroup.getId());
    }

    public LocalGroupRepository getGroupsRepository() {
        return groupsRepository;
    }

    public BaseRepository<UserWithRole> getUserWithRoleRepository() {
        return userWithRoleRepository;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void loadAllTrackedGroups(){
        groupsRepository.addListener(listener);
    }

    public void loadAllLessonsWithFullInformationForSelectedGroup(){
        lessonsWithFullInformationRepository.addLessonsByGroupListener(lessonsByGroupListener);
    }

    public void loadAllUsersWithRole(){
        userWithRoleRepository.addListener(userWithRoleListener);
    }

    private LocalGroupRepository.OnDataChangedListener listener = groups -> trackedGroups.setValue(groups);
    private GroupRepository.CopyGroupListener copyGroupListener =
            copyGroupId -> {
                Group group = new Group(copyGroupId, selectedGroup.getValue().getNumber(), true);
                setSelectedGroup(group);
            };

    private BaseRepository.OnDataChangedListener<UserWithRole> userWithRoleListener = usersWithRole -> users.setValue(usersWithRole);

    public GroupRepository.CopyGroupListener getCopyGroupListener() {
        return copyGroupListener;
    }


    private LessonsWithFullInformationRepository.LessonsByGroupListener lessonsByGroupListener =
            lessonWithFullInformation -> allLessonsWithFullInformationForSelectedGroup.setValue(lessonWithFullInformation);

    public int getCurrentUserId(){
        List<UserWithRole> userList = users.getValue();
        int currentUserId = 0;
        if (userList != null && FirebaseAuth.getInstance().getCurrentUser() != null) {
            for (UserWithRole user : userList) {
                if (user.getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                    currentUserId = user.getId();
                    break;
                }
            }
        }
        return currentUserId;
    }

    public String getCurrentUserRole(){
        List<UserWithRole> userList = users.getValue();
        String currentUserRole = null;
        if (userList != null && FirebaseAuth.getInstance().getCurrentUser() != null) {
            for (UserWithRole user : userList) {
                if (user.getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                    currentUserRole = user.getRole();
                    break;
                }
            }
        }
        return currentUserRole;
    }
}
