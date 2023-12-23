package com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.dao.UserWithRoleDao;
import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.entity.UserWithRoleDataEntity;
import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.mapper.UserWithRoleDataEntityMapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.dao.UserRoleDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity.UserRoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.users.room.dao.UserDao;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserWithRoleRepositoryRoomImpl implements BaseRepository<UserWithRole> {
    private List<UserWithRoleDataEntity> allUsersWithRole = new ArrayList<>();
    private Set<OnDataChangedListener<UserWithRole>> listeners = new HashSet<>();
    private UserWithRoleDao userWithRoleDao;
    private UserDao userDao;
    private UserRoleDao userRoleDao;
    private static final UserWithRoleDataEntityMapper USER_WITH_ROLE_DATA_ENTITY_MAPPER = new UserWithRoleDataEntityMapper();
    public UserWithRoleRepositoryRoomImpl(Application application){
        userWithRoleDao = AppDatabase.getInstance(application).userWithRoleDao();
        userDao = AppDatabase.getInstance(application).userDao();
        userRoleDao = AppDatabase.getInstance(application).userRoleDao();
        new LoadAllUsersWithRoleAsyncTask().execute();
    }


    @Override
    public void insert(UserWithRole item) {
        new InsertUserWithRoleAsyncTask().execute(item);
    }

    @Override
    public void update(UserWithRole item) {

    }

    @Override
    public void delete(UserWithRole item) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserWithRole> getAll() {
        if (allUsersWithRole != null) {
            return USER_WITH_ROLE_DATA_ENTITY_MAPPER.mapFromDBEntity(allUsersWithRole);
        }
        return new ArrayList<>();
    }

    @Override
    public void addListener(OnDataChangedListener<UserWithRole> listener) {
        listeners.add(listener);
        listener.onChanged(USER_WITH_ROLE_DATA_ENTITY_MAPPER.mapFromDBEntity(allUsersWithRole));
    }

    @Override
    public void removeListener(OnDataChangedListener<UserWithRole> listener) {
        listeners.remove(listener);
    }

    protected void notifyChanges() {
        for (OnDataChangedListener<UserWithRole> listener : listeners) {
            listener.onChanged(USER_WITH_ROLE_DATA_ENTITY_MAPPER.mapFromDBEntity(allUsersWithRole));
        }
    }

    private class LoadAllUsersWithRoleAsyncTask extends AsyncTask<Void, Void, List<UserWithRoleDataEntity>> {

        @Override
        protected List<UserWithRoleDataEntity> doInBackground(Void... voids) {
            return userWithRoleDao.getAllUsersWithRole();
        }

        @Override
        protected void onPostExecute(List<UserWithRoleDataEntity> result) {
            allUsersWithRole = result;
            notifyChanges();
        }
    }

    private class InsertUserWithRoleAsyncTask extends AsyncTask<UserWithRole, Void, List<UserWithRoleDataEntity>> {

        @Override
        protected List<UserWithRoleDataEntity> doInBackground(UserWithRole... userWithRoles) {
            Long userId = userDao.insert(new UserDBEntity(0, userWithRoles[0].getEmail()));
            if(userWithRoles[0].getRole() == "user") {
                userRoleDao.insert(new UserRoleDBEntity(userId, 1L));
            }
            else if(userWithRoles[0].getRole() == "admin") {
                userRoleDao.insert(new UserRoleDBEntity(userId, 2L));
            }
            return userWithRoleDao.getAllUsersWithRole();
        }

        @Override
        protected void onPostExecute(List<UserWithRoleDataEntity> result) {
            allUsersWithRole = result;
            notifyChanges();
        }
    }
}
