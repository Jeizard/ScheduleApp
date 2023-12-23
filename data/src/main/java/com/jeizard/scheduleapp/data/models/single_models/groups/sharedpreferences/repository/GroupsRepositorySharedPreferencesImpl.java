package com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.repository;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao.LessonsGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.dao.UserGroupDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.mapper.GroupDBEntityMapper;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.dao.GroupsDao;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.entity.GroupSPEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.mapper.GroupSPEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.LocalGroupRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsRepositorySharedPreferencesImpl implements LocalGroupRepository {
    private GroupsDao groupDao;
    private UserGroupDao userGroupRoomDao;
    private List<GroupSPEntity> allGroups = new ArrayList<>();
    private Set<OnDataChangedListener> listeners = new HashSet<>();
    private static final GroupSPEntityMapper groupSPEntityMapper = new GroupSPEntityMapper();
    private static final GroupDBEntityMapper groupDBEntityMapper = new GroupDBEntityMapper();
    private com.jeizard.scheduleapp.data.models.single_models.groups.room.dao.GroupsDao groupsRoomDao;

    public GroupsRepositorySharedPreferencesImpl(Activity activity, Application application) {
        this.groupDao = new GroupsDao(activity);
        groupsRoomDao = AppDatabase.getInstance(application).groupsDao();
        userGroupRoomDao = AppDatabase.getInstance(application).userGroupDao();
        new LoadAllGroupsAsyncTask().execute();
    }

    @Override
    public void insert(Group group, int userId){
        new InsertGroupAsyncTask(userId).execute(group);
    }

    @Override
    public void update(Group group, int userId) {
        new UpdateGroupAsyncTask(userId).execute(group);
    }

    @Override
    public void delete(Group group, int userId) {
        new DeleteGroupAsyncTask(userId).execute(group);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Group> getAll() {
        if (allGroups != null) {
            return groupSPEntityMapper.mapFromDBEntity(allGroups);
        }
        return new ArrayList<>();
    }

    @Override
    public void reloadGroup(Group group, int userId) {
        new ReloadGroupAsyncTask(userId).execute(group);
    }

    @Override
    public void createGroup(Group group, int userId) {
        new CreateGroupAsyncTask(userId).execute(group);
    }

    @Override
    public void uploadGroupsForCurrentUser(int userId) {
        new UploadGroupsForCurrentUseAsyncTask().execute(userId);
    }

    private class LoadAllGroupsAsyncTask extends AsyncTask<Void, Void, List<GroupSPEntity>> {
        @Override
        protected List<GroupSPEntity> doInBackground(Void... voids) {
            // groupDao.deleteAllGroups();
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
                allGroups = result;
                notifyChanges();
        }
    }


    private class InsertGroupAsyncTask extends AsyncTask<Group, Void, List<GroupSPEntity>> {
        private int userId;
        public InsertGroupAsyncTask(int userId) {
            this.userId = userId;
        }
        @Override
        protected List<GroupSPEntity> doInBackground(Group... groups) {
            groupDao.insert(groupSPEntityMapper.mapToDBEntity(groups[0]));
            if(userId != 0){
                userGroupRoomDao.insert(new UserGroupDBEntity((long) userId, (long) groups[0].getId()));
            }
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    private class UpdateGroupAsyncTask extends AsyncTask<Group, Void, List<GroupSPEntity>> {
        private int userId;
        public UpdateGroupAsyncTask(int userId) {
            this.userId = userId;
        }
        @Override
        protected List<GroupSPEntity> doInBackground(Group... groups) {
            int lastId = groupDao.update(groupSPEntityMapper.mapToDBEntity(groups[0]));
            if(userId != 0){
                if(lastId != 0) {
                    userGroupRoomDao.delete(new UserGroupDBEntity((long) userId, (long) lastId));
                }
                userGroupRoomDao.insert(new UserGroupDBEntity((long) userId, (long) groups[0].getId()));
            }
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    private class DeleteGroupAsyncTask extends AsyncTask<Group, Void, List<GroupSPEntity>> {
        private int userId;
        public DeleteGroupAsyncTask(int userId) {
            this.userId = userId;
        }
        @Override
        protected List<GroupSPEntity> doInBackground(Group... groups) {
            groupDao.delete(groupSPEntityMapper.mapToDBEntity(groups[0]));
            if(groups[0].getLocal()) {
                groupsRoomDao.delete(groupDBEntityMapper.mapToDBEntity(groups[0]));
            }
            if(userId != 0){
                userGroupRoomDao.delete(new UserGroupDBEntity((long) userId, (long) groups[0].getId()));
            }
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    private class ReloadGroupAsyncTask extends AsyncTask<Group, Void, List<GroupSPEntity>> {
        private int userId;
        public ReloadGroupAsyncTask(int userId) {
            this.userId = userId;
        }
        @Override
        protected List<GroupSPEntity> doInBackground(Group... groups) {
            int groupId = groupsRoomDao.getGlobalGroupIdByNumber(groups[0].getNumber());
            if(groupId != 0) {
                int lastId = groupDao.update(groupSPEntityMapper.mapToDBEntity(new Group(groupId, groups[0].getNumber(), true)));
                groupsRoomDao.delete(groupDBEntityMapper.mapToDBEntity(groups[0]));
                if(userId != 0){
                    if(lastId != 0) {
                        userGroupRoomDao.delete(new UserGroupDBEntity((long) userId, (long) lastId));
                    }
                    userGroupRoomDao.insert(new UserGroupDBEntity((long) userId, (long) groups[0].getId()));
                }
            }
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    private class CreateGroupAsyncTask extends AsyncTask<Group, Void, List<GroupSPEntity>> {

        private int userId;
        public CreateGroupAsyncTask(int userId) {
            this.userId = userId;
        }

        @Override
        protected List<GroupSPEntity> doInBackground(Group... groups) {
            int groupId = (int) groupsRoomDao.insert(groupDBEntityMapper.mapToDBEntity(groups[0]));
            if(userId != 0){
               userGroupRoomDao.insert(new UserGroupDBEntity((long) userId, (long) groupId));
            }
            groupDao.insert(groupSPEntityMapper.mapToDBEntity(new Group(groupId, groups[0].getNumber(), true)));
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    private class UploadGroupsForCurrentUseAsyncTask extends AsyncTask<Integer, Void, List<GroupSPEntity>> {
        @Override
        protected List<GroupSPEntity> doInBackground(Integer... integers) {
            groupDao.deleteAllGroups();
            List<UserGroupDBEntity> usersGroup = userGroupRoomDao.getAllGroupsByUserId(integers[0]);
            usersGroup.forEach(userGroupDBEntity -> {
                GroupDBEntity groupDBEntity = groupsRoomDao.getById(Math.toIntExact(userGroupDBEntity.getGroupId()));
                groupDao.insert(new GroupSPEntity(groupDBEntity.getId(), groupDBEntity.getNumber(), groupDBEntity.getLocal()));
            });
            return groupDao.getAllGroups();
        }

        @Override
        protected void onPostExecute(List<GroupSPEntity> result) {
            allGroups = result;
            notifyChanges();
        }
    }

    @Override
    public void addListener(OnDataChangedListener listener) {
        listeners.add(listener);
        listener.onChanged(groupSPEntityMapper.mapFromDBEntity(allGroups));
    }

    @Override
    public void removeListener(OnDataChangedListener listener) {
        listeners.remove(listener);
    }

    private void notifyChanges() {
        for (OnDataChangedListener listener : listeners) {
            listener.onChanged(groupSPEntityMapper.mapFromDBEntity(allGroups));
        }
    }
}
