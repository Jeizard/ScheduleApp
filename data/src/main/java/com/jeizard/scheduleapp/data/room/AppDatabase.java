package com.jeizard.scheduleapp.data.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.dao.GroupsWithFullInformationDao;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.dao.LessonWithFullInformationDao;
import com.jeizard.scheduleapp.data.models.composite_models.user_with_role.room.dao.UserWithRoleDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.dao.GroupYearsFormsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.entity.GroupYearsFormsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.dao.LessonCabinetDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity.LessonCabinetDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.dao.LessonSubjectsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.dao.LessonTypesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_types.room.entity.LessonTypesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.dao.LessonWeekDaysDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity.LessonWeekDaysDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.dao.SpecialityFacultiesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.entity.SpecialityFacultiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.dao.UserGroupDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_groups.room.entity.UserGroupDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.dao.UserRoleDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.user_roles.room.entity.UserRoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.dao.CabinetDao;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.dao.RoleDao;
import com.jeizard.scheduleapp.data.models.single_models.roles.room.entity.RoleDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.users.room.dao.UserDao;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.types.room.dao.LessonTypeDao;
import com.jeizard.scheduleapp.data.models.single_models.types.room.entity.LessonTypeDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.study_years.room.dao.StudyYearsDao;
import com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity.StudyYearDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.dao.EducationFormsDao;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity.EducationFormDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.faculties.room.dao.FacultiesDao;
import com.jeizard.scheduleapp.data.models.single_models.faculties.room.entity.FacultyDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.dao.GroupsDao;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.dao.GroupSpecialtiesDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao.LessonsGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao.LessonTeachersDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.dao.LessonsDao;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.dao.SpecialtiesDao;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.dao.SubjectsDao;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.dao.TeachersDao;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.dao.WeekDaysDao;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.sql.Time;

@Database(
        entities = {
                LessonDBEntity.class,
                GroupDBEntity.class,
                LessonsGroupsDBEntity.class,
                TeacherDBEntity.class,
                LessonTeachersDBEntity.class,
                SpecialityDBEntity.class,
                GroupSpecialtiesDBEntity.class,
                FacultyDBEntity.class,
                SpecialityFacultiesDBEntity.class,
                EducationFormDBEntity.class,
                StudyYearDBEntity.class,
                GroupYearsFormsDBEntity.class,
                WeekDayDBEntity.class,
                LessonWeekDaysDBEntity.class,
                SubjectDBEntity.class,
                LessonSubjectsDBEntity.class,
                CabinetDBEntity.class,
                LessonCabinetDBEntity.class,
                LessonTypeDBEntity.class,
                LessonTypesDBEntity.class,
                UserDBEntity.class,
                RoleDBEntity.class,
                UserRoleDBEntity.class,
                UserGroupDBEntity.class
        },
        version = 1,
        exportSchema = false)
@TypeConverters(
        {Converters.class}
)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract LessonsDao lessonsDao();
    public abstract GroupsDao groupsDao();
    public abstract LessonsGroupsDao lessonGroupsDao();
    public abstract TeachersDao teachersDao();
    public abstract LessonTeachersDao lessonTeachersDao();
    public abstract SpecialtiesDao specialtiesDao();
    public abstract GroupSpecialtiesDao groupSpecialtiesDao();
    public abstract FacultiesDao facultiesDao();
    public abstract SpecialityFacultiesDao specialityFacultiesDao();
    public abstract EducationFormsDao educationFormsDao();
    public abstract StudyYearsDao studyYearsDao();
    public abstract GroupYearsFormsDao groupYearsFormsDao();
    public abstract GroupsWithFullInformationDao groupsWithFullInformationDao();
    public abstract WeekDaysDao weekDaysDao();
    public abstract LessonWeekDaysDao lessonWeekDaysDao();
    public abstract LessonWithFullInformationDao lessonWithFullInformationDao();
    public abstract SubjectsDao subjectsDao();
    public abstract LessonSubjectsDao lessonSubjectsDao();
    public abstract CabinetDao cabinetDao();
    public abstract LessonCabinetDao lessonCabinetDao();
    public abstract LessonTypeDao lessonTypeDao();
    public abstract LessonTypesDao lessonTypesDao();
    public abstract UserDao userDao();
    public abstract RoleDao roleDao();
    public abstract UserRoleDao userRoleDao();
    public abstract UserWithRoleDao userWithRoleDao();
    public abstract UserGroupDao userGroupDao();

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

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private LessonsDao lessonsDao;
        private GroupsDao groupsDao;
        private TeachersDao teachersDao;
        private LessonsGroupsDao lessonGroupsDao;
        private LessonTeachersDao lessonTeachersDao;
        private SpecialtiesDao specialtiesDao;
        private GroupSpecialtiesDao groupSpecialtiesDao;
        private FacultiesDao facultiesDao;
        private SpecialityFacultiesDao specialityFacultiesDao;
        private EducationFormsDao educationFormsDao;
        private StudyYearsDao studyYearsDao;
        private GroupYearsFormsDao groupYearsFormsDao;
        private WeekDaysDao weekDaysDao;
        private LessonWeekDaysDao lessonWeekDaysDao;
        private SubjectsDao subjectsDao;
        private LessonSubjectsDao lessonSubjectsDao;
        private CabinetDao cabinetDao;
        private LessonCabinetDao lessonCabinetDao;
        private LessonTypeDao lessonTypeDao;
        private LessonTypesDao lessonTypesDao;
        private UserDao userDao;
        private RoleDao roleDao;
        private UserRoleDao userRoleDao;
        private UserGroupDao userGroupDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            lessonsDao = db.lessonsDao();
            groupsDao = db.groupsDao();
            teachersDao = db.teachersDao();
            lessonGroupsDao = db.lessonGroupsDao();
            lessonTeachersDao = db.lessonTeachersDao();
            specialtiesDao = db.specialtiesDao();
            groupSpecialtiesDao = db.groupSpecialtiesDao();
            facultiesDao = db.facultiesDao();
            specialityFacultiesDao = db.specialityFacultiesDao();
            educationFormsDao = db.educationFormsDao();
            studyYearsDao = db.studyYearsDao();
            groupYearsFormsDao = db.groupYearsFormsDao();
            weekDaysDao = db.weekDaysDao();
            lessonWeekDaysDao = db.lessonWeekDaysDao();
            subjectsDao = db.subjectsDao();
            lessonSubjectsDao = db.lessonSubjectsDao();
            cabinetDao = db.cabinetDao();
            lessonCabinetDao = db.lessonCabinetDao();
            lessonTypeDao = db.lessonTypeDao();
            lessonTypesDao = db.lessonTypesDao();
            userDao = db.userDao();
            roleDao = db.roleDao();
            userRoleDao = db.userRoleDao();
            userGroupDao = db.userGroupDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//            addFirebaseListener(firebaseDatabase.getReference("lessons"), lessonsDao, LessonDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("groups"), groupsDao, GroupDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lessons_groups"), lessonGroupsDao, LessonsGroupsDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("teachers"), teachersDao, TeacherDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lesson_teachers"), lessonTeachersDao, LessonTeachersDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("specialties"), specialtiesDao, SpecialityDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("group_specialties"), groupSpecialtiesDao, GroupSpecialtiesDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("faculties"), facultiesDao, FacultyDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("speciality_faculties"), specialityFacultiesDao, SpecialityFacultiesDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("education_forms"), educationFormsDao, EducationFormDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("study_years"), studyYearsDao, StudyYearDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("group_years_forms"), groupYearsFormsDao, GroupYearsFormsDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("week_days"), weekDaysDao, WeekDayDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lesson_week_days"), lessonWeekDaysDao, LessonWeekDaysDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("subjects"), subjectsDao, SubjectDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lesson_subjects"), lessonSubjectsDao, LessonSubjectsDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("cabinets"), cabinetDao, CabinetDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lesson_cabinets"), lessonCabinetDao, LessonCabinetDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("lesson_types"), lessonTypesDao, LessonTypesDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("users"), userDao, UserDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("roles"), roleDao, RoleDBEntity.class);
//            addFirebaseListener(firebaseDatabase.getReference("user_roles"), userRoleDao, UserRoleDBEntity.class);

//            DatabaseReference groupsRef = firebaseDatabase.getReference("groups");
//            groupsRef.push().setValue(new GroupDBEntity(1, "110902", false));
//            groupsRef.push().setValue(new GroupDBEntity(2, "110903", true));
//            groupsRef.push().setValue(new GroupDBEntity(3, "110901", false));

            lessonsDao.insert(new LessonDBEntity(0, Time.valueOf("09:00:00") , Time.valueOf("10:35:00") ));
            groupsDao.insert(new GroupDBEntity(0, "110902", false));
            teachersDao.insert(new TeacherDBEntity(0, "Иванов", "Иван", "Иванович" ));
            lessonGroupsDao.insert(new LessonsGroupsDBEntity(1L, 1L));
            lessonTeachersDao.insert(new LessonTeachersDBEntity(1L, 1L ));
            specialtiesDao.insert(new SpecialityDBEntity(0, "Инженерно-психологическое обеспечение информационных технологий", "ИПОИТ"));
            groupSpecialtiesDao.insert(new GroupSpecialtiesDBEntity(1, 1));
            facultiesDao.insert(new FacultyDBEntity(0, "Факультет компьютерного проектирования", "ФКП"));
            specialityFacultiesDao.insert(new SpecialityFacultiesDBEntity(1, 1));
            educationFormsDao.insert(new EducationFormDBEntity(0, "Дневная"));
            educationFormsDao.insert(new EducationFormDBEntity(0, "Заочная"));
            studyYearsDao.insert(new StudyYearDBEntity(0, "1"));
            studyYearsDao.insert(new StudyYearDBEntity(0, "2"));
            studyYearsDao.insert(new StudyYearDBEntity(0, "3"));
            studyYearsDao.insert(new StudyYearDBEntity(0, "4"));
            groupYearsFormsDao.insert(new GroupYearsFormsDBEntity(1, 3, 1));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Понедельник", "ПН"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Вторник", "ВТ"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Среда", "СР"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Четверг", "ЧТ"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Пятница", "ПТ"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Суббота", "СБ"));
            weekDaysDao.insert(new WeekDayDBEntity(0, "Воскресенье", "ВС"));
            lessonWeekDaysDao.insert(new LessonWeekDaysDBEntity(1L, 1L));
            subjectsDao.insert(new SubjectDBEntity(0, "Предмет", "П"));
            lessonSubjectsDao.insert(new LessonSubjectsDBEntity(1L, 1L));
            cabinetDao.insert(new CabinetDBEntity(0, "666"));
            lessonCabinetDao.insert(new LessonCabinetDBEntity(1L, 1L));
            lessonTypeDao.insert(new LessonTypeDBEntity(0, "Лекция", "ЛК"));
            lessonTypeDao.insert(new LessonTypeDBEntity(0, "Практическое занятие", "ПЗ"));
            lessonTypeDao.insert(new LessonTypeDBEntity(0, "Лабораторная работа", "ЛР"));
            lessonTypesDao.insert(new LessonTypesDBEntity(1L, 1L));
            userDao.insert(new UserDBEntity(0, "user@mail.ru"));
            roleDao.insert(new RoleDBEntity(0, "user"));
            userDao.insert(new UserDBEntity(0, "admin@mail.ru"));
            roleDao.insert(new RoleDBEntity(0, "admin"));
            userRoleDao.insert(new UserRoleDBEntity(1L, 1L));
            userRoleDao.insert(new UserRoleDBEntity(2L, 2L));
            return null;
        }
    }

//    private static <T> void addFirebaseListener(DatabaseReference reference, final BaseDao<T> dao, Class<T> entityClass) {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    T entity = snapshot.getValue(entityClass);
//                    if (entity != null) {
//                        dao.insert(entity);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // Обработка ошибок при чтении данных из Firebase
//            }
//        });
//    }
}
