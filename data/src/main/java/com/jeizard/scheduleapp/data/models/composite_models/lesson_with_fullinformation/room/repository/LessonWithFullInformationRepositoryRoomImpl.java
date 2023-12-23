package com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.entity.LessonWithFullInformationDataEntity;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.dao.LessonWithFullInformationDao;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.mapper.LessonWithFullInformationDataEntityMapper;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.dao.LessonCabinetDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity.LessonCabinetDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.dao.LessonSubjectsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao.LessonTeachersDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.dao.LessonTypesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity.LessonTypesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.dao.LessonWeekDaysDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity.LessonWeekDaysDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao.LessonsGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.dao.CabinetDao;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.dao.LessonsDao;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.dao.SubjectsDao;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.dao.TeachersDao;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.types.room.dao.LessonTypeDao;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.dao.WeekDaysDao;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonTypes;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LessonWithFullInformationRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonWithFullInformationDataEntity, LessonWithFullInformationDao, LessonWithFullInformation> implements LessonsWithFullInformationRepository {
    private static final LessonWithFullInformationDataEntityMapper lessonWithFullInformationDataEntityMapper = new LessonWithFullInformationDataEntityMapper();
    private List<LessonWithFullInformationDataEntity> allLessons = new ArrayList<>();
    private Set<LessonsByGroupListener> lessonsListeners = new HashSet<>();
    private LessonWithFullInformationDao lessonWithFullInformationDao;

    private LessonsDao lessonsDao;
    private SubjectsDao subjectsDao;
    private LessonSubjectsDao lessonSubjectsDao;
    private WeekDaysDao weekDaysDao;
    private LessonWeekDaysDao lessonWeekDaysDao;
    private TeachersDao teachersDao;
    private LessonTeachersDao lessonTeachersDao;
    private CabinetDao cabinetDao;
    private LessonCabinetDao lessonCabinetDao;
    private LessonTypeDao lessonTypeDao;
    private LessonTypesDao lessonTypesDao;
    private LessonsGroupsDao lessonsGroupsDao;

    public LessonWithFullInformationRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonWithFullInformationDao(), lessonWithFullInformationDataEntityMapper);
        lessonWithFullInformationDao = AppDatabase.getInstance(application).lessonWithFullInformationDao();
        lessonsDao = AppDatabase.getInstance(application).lessonsDao();
        subjectsDao = AppDatabase.getInstance(application).subjectsDao();
        lessonSubjectsDao = AppDatabase.getInstance(application).lessonSubjectsDao();
        weekDaysDao = AppDatabase.getInstance(application).weekDaysDao();
        lessonWeekDaysDao = AppDatabase.getInstance(application).lessonWeekDaysDao();
        teachersDao = AppDatabase.getInstance(application).teachersDao();
        lessonTeachersDao = AppDatabase.getInstance(application).lessonTeachersDao();
        cabinetDao = AppDatabase.getInstance(application).cabinetDao();
        lessonCabinetDao = AppDatabase.getInstance(application).lessonCabinetDao();
        lessonTypeDao = AppDatabase.getInstance(application).lessonTypeDao();
        lessonTypesDao = AppDatabase.getInstance(application).lessonTypesDao();
        lessonsGroupsDao = AppDatabase.getInstance(application).lessonGroupsDao();
    }

    @Override
    public void insertLessonsByGroup(LessonWithFullInformation lesson, int groupId) {
        new InsertLessonWithFullInfAsyncTask(groupId).execute(lesson);
    }

    @Override
    public void deleteLessonForLocalGroup(int lessonId, int groupId) {
        new DeleteLessonsForLocalGroup(lessonId).execute(groupId);
    }

    @Override
    public void getLessonsByGroup(int groupId) {
        new LoadLessonsByGroupAsyncTask().execute(groupId);
    }

    @Override
    public void addLessonsByGroupListener(LessonsByGroupListener listener) {
        lessonsListeners.add(listener);
        listener.onChanged(lessonWithFullInformationDataEntityMapper.mapFromDBEntity(allItems));
    }

    @Override
    public void removeLessonsByGroupListener(LessonsByGroupListener listener) {
        lessonsListeners.remove(listener);
    }

    public void notifyChanges() {
        for (LessonsByGroupListener listener : lessonsListeners) {
            listener.onChanged(lessonWithFullInformationDataEntityMapper.mapFromDBEntity(allLessons));
        }
    }


    private class InsertLessonWithFullInfAsyncTask extends AsyncTask<LessonWithFullInformation, Void, List<LessonWithFullInformationDataEntity>> {

        private int groupId;

        public InsertLessonWithFullInfAsyncTask(int groupId) {
            this.groupId = groupId;
        }

        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(LessonWithFullInformation... lessonWithFullInformation) {
            LessonDBEntity lessonDBEntity = new LessonDBEntity(0, lessonWithFullInformation[0].getStartTime(), lessonWithFullInformation[0].getEndTime());
            long lessonId = lessonsDao.insert(lessonDBEntity);

            SubjectDBEntity subjectDBEntity = new SubjectDBEntity(0, lessonWithFullInformation[0].getSubjectTitle(), lessonWithFullInformation[0].getSubjectAbbreviation());
            long subjectId = subjectsDao.insert(subjectDBEntity);

            LessonSubjectsDBEntity lessonSubjectsDBEntity = new LessonSubjectsDBEntity(lessonId, subjectId);
            lessonSubjectsDao.insert(lessonSubjectsDBEntity);

            TeacherDBEntity teacherDBEntity = new TeacherDBEntity(0, lessonWithFullInformation[0].getTeacherSurname(), lessonWithFullInformation[0].getTeacherName(), lessonWithFullInformation[0].getTeacherPatronymic());
            long teacherId = teachersDao.insert(teacherDBEntity);

            LessonTeachersDBEntity lessonTeachersDBEntity = new LessonTeachersDBEntity(lessonId, teacherId);
            lessonTeachersDao.insert(lessonTeachersDBEntity);

            CabinetDBEntity cabinetDBEntity = new CabinetDBEntity(0, lessonWithFullInformation[0].getCabinetNumber());
            long cabinetId = cabinetDao.insert(cabinetDBEntity);

            LessonCabinetDBEntity lessonCabinetDBEntity = new LessonCabinetDBEntity(lessonId, cabinetId);
            lessonCabinetDao.insert(lessonCabinetDBEntity);

            int weekdayId = weekDaysDao.getWeekDayIdByTitle(lessonWithFullInformation[0].getWeekDayTitle());
            LessonWeekDaysDBEntity lessonWeekDaysDBEntity = new LessonWeekDaysDBEntity(lessonId, (long) weekdayId);
            lessonWeekDaysDao.insert(lessonWeekDaysDBEntity);

            int typeId = lessonTypeDao.getTypeIdByTitle(lessonWithFullInformation[0].getTypeTitle());
            LessonTypesDBEntity lessonTypesDBEntity = new LessonTypesDBEntity(lessonId, (long) typeId);
            lessonTypesDao.insert(lessonTypesDBEntity);

            LessonsGroupsDBEntity lessonsGroupsDBEntity = new LessonsGroupsDBEntity(lessonId, (long) groupId);
            lessonsGroupsDao.insert(lessonsGroupsDBEntity);

            return lessonWithFullInformationDao.getAllLessonsWithFullInformationByGroup((long) groupId);
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
            allLessons = result;
            notifyChanges();
        }
    }

    private class DeleteLessonsForLocalGroup extends AsyncTask<Integer, Void, List<LessonWithFullInformationDataEntity>> {
        private int lessonId;

        public DeleteLessonsForLocalGroup(int lessonId) {
            this.lessonId = lessonId;
        }

        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(Integer... integers) {
            lessonWithFullInformationDao.deleteLessonForGroup(Long.valueOf(lessonId), Long.valueOf(integers[0]));
            return lessonWithFullInformationDao.getAllLessonsWithFullInformationByGroup(Long.valueOf(integers[0]));
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
            allLessons = result;
            notifyChanges();
        }
    }

    private class LoadLessonsByGroupAsyncTask extends AsyncTask<Integer, Void, List<LessonWithFullInformationDataEntity>> {
        @Override
        protected List<LessonWithFullInformationDataEntity> doInBackground(Integer... integers) {
            return lessonWithFullInformationDao.getAllLessonsWithFullInformationByGroup(Long.valueOf(integers[0]));
        }

        @Override
        protected void onPostExecute(List<LessonWithFullInformationDataEntity> result) {
            allLessons = result;
            notifyChanges();
        }
    }
}
