package com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.dao.GroupsWithFullInformationDao;
import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.entity.GroupWithFullInformationDataEntity;
import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.mapper.GroupWithSpecialityAndFacultyDataEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;
import com.jeizard.scheduleapp.domain.model.repository.GroupRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupWithFullInformationRepositoryRoomImpl implements BaseRepository<GroupWithFullInformation> {
    private GroupRepository groupsRepository;
    private List<GroupWithFullInformationDataEntity> allGroupsWithSpecialties = new ArrayList<>();
    private Set<BaseRepository.OnDataChangedListener<GroupWithFullInformation>> listeners = new HashSet<>();
    private GroupsWithFullInformationDao groupsWithFullInformationDao;
    private static final GroupWithSpecialityAndFacultyDataEntityMapper groupWithSpecialityDataEntityMapper = new GroupWithSpecialityAndFacultyDataEntityMapper();
    public GroupWithFullInformationRepositoryRoomImpl(Application application, GroupRepository groupsRepository){
        this.groupsWithFullInformationDao = AppDatabase.getInstance(application).groupsWithFullInformationDao();
        this.groupsRepository = groupsRepository;
        groupsRepository.addListener(listener);
        new LoadAllGroupsWithSpecialtiesAsyncTask().execute();
    }

    @Override
    public void insert(GroupWithFullInformation item) {
    }

    @Override
    public void update(GroupWithFullInformation item) {
    }

    @Override
    public void delete(GroupWithFullInformation item) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public List<GroupWithFullInformation> getAll() {
        if (allGroupsWithSpecialties != null) {
            return groupWithSpecialityDataEntityMapper.mapFromDBEntity(allGroupsWithSpecialties);
        }
        return new ArrayList<>();
    }

    @Override
    public void addListener(OnDataChangedListener<GroupWithFullInformation> listener) {
        listeners.add(listener);
        listener.onChanged(groupWithSpecialityDataEntityMapper.mapFromDBEntity(allGroupsWithSpecialties));
    }

    @Override
    public void removeListener(OnDataChangedListener<GroupWithFullInformation> listener) {
        listeners.remove(listener);
    }

    protected void notifyChanges() {
        for (BaseRepository.OnDataChangedListener<GroupWithFullInformation> listener : listeners) {
            listener.onChanged(groupWithSpecialityDataEntityMapper.mapFromDBEntity(allGroupsWithSpecialties));
        }
    }

    private class LoadAllGroupsWithSpecialtiesAsyncTask extends AsyncTask<Void, Void, List<GroupWithFullInformationDataEntity>> {

        @Override
        protected List<GroupWithFullInformationDataEntity> doInBackground(Void... voids) {
            return groupsWithFullInformationDao.getAllGroupsWithFullInformation();
        }

        @Override
        protected void onPostExecute(List<GroupWithFullInformationDataEntity> result) {
            allGroupsWithSpecialties = result;
            notifyChanges();
        }
    }

    private class UpdateGroupsWithSpecialtiesAsyncTask extends AsyncTask<Void, Void, List<GroupWithFullInformationDataEntity>> {

        @Override
        protected List<GroupWithFullInformationDataEntity> doInBackground(Void... voids) {
            return groupsWithFullInformationDao.getAllGroupsWithFullInformation();
        }

        @Override
        protected void onPostExecute(List<GroupWithFullInformationDataEntity> result) {
            allGroupsWithSpecialties = result;
            notifyChanges();
        }
    }


    private BaseRepository.OnDataChangedListener<Group> listener = groups -> new UpdateGroupsWithSpecialtiesAsyncTask().execute();
}
