package com.jeizard.scheduleapp.data.room.repository;

import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class   BaseRepositoryRoomImpl<DBEntity, DAO extends BaseDao, Entity> implements BaseRepository<Entity> {
    protected List<DBEntity> allItems = new ArrayList<>();
    private Set<BaseRepository.OnDataChangedListener<Entity>> listeners = new HashSet<>();
    private Mapper<DBEntity, Entity> mapper;
    protected BaseDao dao;

    public BaseRepositoryRoomImpl(DAO dao, Mapper<DBEntity, Entity> mapper) {
        this.dao = dao;
        this.mapper = mapper;
        new LoadAllItemsAsyncTask().execute();
    }

    @Override
    public void insert(Entity item) {
        new InsertItemAsyncTask().execute(item);
    }

    @Override
    public void update(Entity item) {
        new UpdateItemAsyncTask().execute(item);
    }

    @Override
    public void delete(Entity item) {
        new DeleteItemAsyncTask().execute(item);
    }

    @Override
    public void deleteAll() {
        new DeleteAllItemsAsyncTask().execute();
    }

    @Override
    public List<Entity> getAll() {
        if (allItems != null) {
            return mapper.mapFromDBEntity(allItems);
        }
        return new ArrayList<>();
    }

    @Override
    public void addListener(BaseRepository.OnDataChangedListener<Entity> listener) {
        listeners.add(listener);
        listener.onChanged(mapper.mapFromDBEntity(allItems));
    }

    @Override
    public void removeListener(BaseRepository.OnDataChangedListener<Entity> listener) {
        listeners.remove(listener);
    }

    protected void notifyChanges() {
        for (BaseRepository.OnDataChangedListener<Entity> listener : listeners) {
            listener.onChanged(mapper.mapFromDBEntity(allItems));
        }
    }

    private class LoadAllItemsAsyncTask extends AsyncTask<Void, Void, List<DBEntity>> {
        @Override
        protected List<DBEntity> doInBackground(Void... voids) {
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<DBEntity> result) {
            allItems = result;
            notifyChanges();
        }
    }

    private class InsertItemAsyncTask extends AsyncTask<Entity, Void, List<DBEntity>> {
        @Override
        protected List<DBEntity> doInBackground(Entity... items) {
            dao.insert(mapper.mapToDBEntity(items[0]));
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<DBEntity> result) {
           allItems = result;
           notifyChanges();
        }
    }

    private class UpdateItemAsyncTask extends AsyncTask<Entity, Void, List<DBEntity>> {
        @Override
        protected List<DBEntity> doInBackground(Entity... items) {
            dao.update(mapper.mapToDBEntity(items[0]));
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<DBEntity> result) {
            allItems = result;
            notifyChanges();
        }
    }

    private class DeleteItemAsyncTask extends AsyncTask<Entity, Void, List<DBEntity>> {
        @Override
        protected List<DBEntity> doInBackground(Entity... items) {
            dao.update(mapper.mapToDBEntity(items[0]));
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<DBEntity> result) {
            allItems = result;
            notifyChanges();
        }
    }

    private class DeleteAllItemsAsyncTask extends AsyncTask<Entity, Void, List<DBEntity>> {
        @Override
        protected List<DBEntity> doInBackground(Entity... items) {
            dao.deleteAll();
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<DBEntity> result) {
            allItems = result;
            notifyChanges();
        }
    }
}
