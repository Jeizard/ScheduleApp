package com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.sharedpreferences.repository;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.entity.LessonWithFullInformationDataEntity;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.mapper.LessonWithFullInformationDataEntityMapper;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.dao.LessonWithFullInformationDao;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.sharedpreferences.dao.LessonWithWeekDayDao;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.domain.model.repository.LessonWithWeekDayRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LessonWithWeekDayRepositorySharedPreferencesImpl implements LessonWithWeekDayRepository {
    private String groupNumber;
    private LessonWithWeekDayDao lessonWithWeekDayDao;
    private LessonWithFullInformationDao lessonWithWeekDayDBDao;
    private List<LessonWithFullInformationDataEntity> allLessonsWithWeekDaysByGroup = new ArrayList<>();
    private Set<OnDataChangedListener> listeners = new HashSet<>();
    private static final LessonWithFullInformationDataEntityMapper lessonWithWeekDayDataEntityMapper = new LessonWithFullInformationDataEntityMapper();

    public LessonWithWeekDayRepositorySharedPreferencesImpl(Application application, Activity activity) {
        this.lessonWithWeekDayDao = new LessonWithWeekDayDao(activity);
        this.lessonWithWeekDayDBDao = AppDatabase.getInstance(application).lessonWithFullInformationDao();
        new LoadAllLessonsWithWeekDaysByGroupAsyncTask(lessonWithWeekDayDao).execute();
    }

    @Override
    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
        new LoadAllLessonsWithWeekDaysByGroupAsyncTask(lessonWithWeekDayDao).execute();
    }

    @Override
    public void insert(com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation lessonWithWeekDay){
        new InsertLessonWithWeekDayByGroupAsyncTask(lessonWithWeekDayDao).execute(lessonWithWeekDay);
    }

    @Override
    public void insertFromBDByGroup(String groupNumber){
        this.groupNumber = groupNumber;
        new LoadLessonWithWeekDayFromDBByGroupAsyncTask(lessonWithWeekDayDao).execute();
    }

    @Override
    public List<com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation> getAll() {
        if (allLessonsWithWeekDaysByGroup != null) {
            return lessonWithWeekDayDataEntityMapper.mapFromDBEntity(allLessonsWithWeekDaysByGroup);
        }
        return new ArrayList<>();
    }

    private class LoadAllLessonsWithWeekDaysByGroupAsyncTask extends AsyncTask<Void, Void, List<LessonWithFullInformationDataEntity>> {
        private LessonWithWeekDayDao lessonWithWeekDayDao;

        private LoadAllLessonsWithWeekDaysByGroupAsyncTask(LessonWithWeekDayDao lessonWithWeekDayDao) {
            this.lessonWithWeekDayDao = lessonWithWeekDayDao;
        }
        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(Void... voids) {
            // lessonWithWeekDayDao.deleteAllLessonsWithWeekDay();
            return lessonWithWeekDayDao.loadByGroup(groupNumber);
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
                allLessonsWithWeekDaysByGroup = result;
                notifyChanges();
        }
    }


    private class InsertLessonWithWeekDayByGroupAsyncTask extends AsyncTask<com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation, Void, List<LessonWithFullInformationDataEntity>> {
        private LessonWithWeekDayDao lessonWithWeekDayDao;

        private InsertLessonWithWeekDayByGroupAsyncTask(LessonWithWeekDayDao lessonWithWeekDayDao) {
            this.lessonWithWeekDayDao = lessonWithWeekDayDao;
        }

        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation... lessonWithWeekDays) {
            lessonWithWeekDayDao.insertByGroup(groupNumber, lessonWithWeekDayDataEntityMapper.mapToDBEntity(lessonWithWeekDays[0]));
            return lessonWithWeekDayDao.loadByGroup(groupNumber);
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
            allLessonsWithWeekDaysByGroup = result;
            notifyChanges();
        }
    }

    private class LoadLessonWithWeekDayFromDBByGroupAsyncTask extends AsyncTask<Void, Void, List<LessonWithFullInformationDataEntity>> {
        private LessonWithWeekDayDao lessonWithWeekDayDao;

        private LoadLessonWithWeekDayFromDBByGroupAsyncTask(LessonWithWeekDayDao lessonWithWeekDayDao) {
            this.lessonWithWeekDayDao = lessonWithWeekDayDao;
        }

        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(Void... voids) {
            List<LessonWithFullInformationDataEntity> allLessonsWithWeekDaysByGroupNumber = lessonWithWeekDayDBDao.getAllLessonsWithFullInformation();
            lessonWithWeekDayDao.saveByGroup(groupNumber, allLessonsWithWeekDaysByGroupNumber);
            return lessonWithWeekDayDao.loadByGroup(groupNumber);
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
            allLessonsWithWeekDaysByGroup = result;
            notifyChanges();
        }
    }


    @Override
    public void addListener(OnDataChangedListener listener) {
        listeners.add(listener);
        listener.onChanged(lessonWithWeekDayDataEntityMapper.mapFromDBEntity(allLessonsWithWeekDaysByGroup));
    }

    @Override
    public void removeListener(OnDataChangedListener listener) {
        listeners.remove(listener);
    }

    private void notifyChanges() {
        for (OnDataChangedListener listener : listeners) {
            listener.onChanged(lessonWithWeekDayDataEntityMapper.mapFromDBEntity(allLessonsWithWeekDaysByGroup));
        }
    }
}
