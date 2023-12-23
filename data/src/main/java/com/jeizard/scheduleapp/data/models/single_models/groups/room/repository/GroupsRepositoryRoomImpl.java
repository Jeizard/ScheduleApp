package com.jeizard.scheduleapp.data.models.single_models.groups.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao.LessonsGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.dao.UserGroupDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.dao.GroupsDao;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.mapper.GroupDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsRepositoryRoomImpl extends BaseRepositoryRoomImpl<GroupDBEntity, GroupsDao, Group> implements GroupRepository {
    private static final GroupDBEntityMapper groupDBEntityMapper = new GroupDBEntityMapper();
    private int copyGroupId;
    private Set<CopyGroupListener> copyGroupListeners = new HashSet<>();
    private LessonsGroupsDao lessonsGroupsDao;
    private UserGroupDao userGroupRoomDao;
    private GroupsDao groupsDao;

    public GroupsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).groupsDao(), groupDBEntityMapper);
        lessonsGroupsDao = AppDatabase.getInstance(application).lessonGroupsDao();
        userGroupRoomDao = AppDatabase.getInstance(application).userGroupDao();
        groupsDao = AppDatabase.getInstance(application).groupsDao();
    }

    @Override
    public void insert(Group item) {
        new InsertItemAsyncTask().execute(item);
        super.getAll();
    }

    @Override
    public void update(Group item) {
        new UpdateItemAsyncTask().execute(item);
    }

    private class InsertItemAsyncTask extends AsyncTask<Group, Void, Long> {
        @Override
        protected Long doInBackground(Group... groups) {
            return dao.insert(groupDBEntityMapper.mapToDBEntity(groups[0]));
        }

        @Override
        protected void onPostExecute(Long result) {
            copyGroupId = Math.toIntExact(result);
            notifyCopyGroupChanges();
        }
    }

    private class UpdateItemAsyncTask extends AsyncTask<Group, Void, List<GroupDBEntity>> {
        @Override
        protected List<GroupDBEntity>  doInBackground(Group... groups) {
            int groupId = groupsDao.getGlobalGroupIdByNumber(groups[0].getNumber());
            if(groupId != groups[0].getId() && groupId != 0){
                dao.delete(groupDBEntityMapper.mapToDBEntity(new Group(groupId, groups[0].getNumber(), false)));
            }
            dao.update(groupDBEntityMapper.mapToDBEntity(new Group(groups[0].getId(), groups[0].getNumber(), false)));
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<GroupDBEntity> result) {
            allItems = result;
            notifyChanges();
        }
    }

    @Override
    public void createCopy(Group group, int userId) {
        new CreateLocalCopyGroupAsyncTask(userId).execute(group);
        super.getAll();
    }

    private class CreateLocalCopyGroupAsyncTask extends AsyncTask<Group, Void, Long> {
        private int userId;
        public CreateLocalCopyGroupAsyncTask(int userId) {
            this.userId = userId;
        }
        @Override
        protected Long doInBackground(Group... groups) {
            Long groupId = dao.insert(groupDBEntityMapper.mapToDBEntity(new Group(0, groups[0].getNumber(), true)));
            if(userId != 0){
                userGroupRoomDao.insert(new UserGroupDBEntity((long) userId, groupId));
            }
            List<LessonsGroupsDBEntity> lessonsGroupsDBEntityList = lessonsGroupsDao.getLessonsGroupsForGroup(groups[0].getId());
            lessonsGroupsDBEntityList.forEach(lessonsGroupsDBEntity -> {
                LessonsGroupsDBEntity newLessonGroupsDBEntity = new LessonsGroupsDBEntity(lessonsGroupsDBEntity.getLessonId(), groupId);
                lessonsGroupsDao.insert(newLessonGroupsDBEntity);
            });
            return groupId;
        }

        @Override
        protected void onPostExecute(Long result) {
            copyGroupId = Math.toIntExact(result);
            notifyCopyGroupChanges();
        }
    }

    @Override
    public void addCopyGroupListener(CopyGroupListener listener) {
        copyGroupListeners.add(listener);
    }

    @Override
    public void removeCopyGroupListener(CopyGroupListener listener) {
        copyGroupListeners.remove(listener);
    }

    public void notifyCopyGroupChanges() {
        for (CopyGroupListener listener : copyGroupListeners) {
            listener.onChanged(copyGroupId);
        }
    }
}

