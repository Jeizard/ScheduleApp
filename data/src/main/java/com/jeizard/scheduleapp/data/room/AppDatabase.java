package com.jeizard.scheduleapp.data.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jeizard.scheduleapp.data.models.groups.room.dao.GroupsDao;
import com.jeizard.scheduleapp.data.models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.dao.LessonGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.entity.LessonGroupsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao.LessonTeachersDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.data.models.lessons.room.dao.LessonsDao;
import com.jeizard.scheduleapp.data.models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.teachers.room.dao.TeachersDao;
import com.jeizard.scheduleapp.data.models.teachers.room.entity.TeacherDBEntity;

import java.sql.Time;

@Database(
        entities = {
                LessonDBEntity.class,
                GroupDBEntity.class,
                LessonGroupsDBEntity.class,
                TeacherDBEntity.class,
                LessonTeachersDBEntity.class
        },
        version = 1)
@TypeConverters(
        {Converters.class}
)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract LessonsDao lessonsDao();
    public abstract GroupsDao groupsDao();
    public abstract LessonGroupsDao lessonGroupsDao();
    public abstract TeachersDao teachersDao();
    public abstract LessonTeachersDao lessonTeachersDao();
    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "schedule_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private  static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private LessonsDao lessonsDao;
        private GroupsDao groupsDao;
        private TeachersDao teachersDao;
        private LessonGroupsDao lessonGroupsDao;
        private LessonTeachersDao lessonTeachersDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            lessonsDao = db.lessonsDao();
            groupsDao = db.groupsDao();
            teachersDao = db.teachersDao();
            lessonGroupsDao = db.lessonGroupsDao();
            lessonTeachersDao = db.lessonTeachersDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            lessonsDao.insert(new LessonDBEntity(0, Time.valueOf("09:00:00") , Time.valueOf("10:35:00") ));
            groupsDao.insert(new GroupDBEntity(0, "110902" ));
            teachersDao.insert(new TeacherDBEntity(0, "Иванов", "Иван", "Иванович" ));
            lessonGroupsDao.insert(new LessonGroupsDBEntity(1, 1 ));
            lessonTeachersDao.insert(new LessonTeachersDBEntity(1, 1 ));
            return null;
        }
    }
}
