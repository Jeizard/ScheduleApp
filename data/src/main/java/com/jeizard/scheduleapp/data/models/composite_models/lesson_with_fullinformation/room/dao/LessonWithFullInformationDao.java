package com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.entity.LessonWithFullInformationDataEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_subjects.room.entity.LessonSubjectsDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

import java.util.List;

@Dao
public abstract class LessonWithFullInformationDao implements BaseDao<LessonWithFullInformation> {

    @Override
    public long insert(LessonWithFullInformation entity) {
        return 0;
    }

    @Override
    public void update(LessonWithFullInformation entity) {

    }

    @Override
    public void delete(LessonWithFullInformation entity) {
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LessonWithFullInformation> getAll() {
        return null;
    }

    @Query("SELECT " +
            "lessons.id, " +
            "lessons.start_time AS startTime, " +
            "lessons.end_time AS endTime," +
            "week_days.title AS weekDayTitle, " +
            "week_days.abbreviation AS weekDayAbbreviation, " +
            "subjects.title AS subjectTitle," +
            "subjects.abbreviation AS subjectAbbreviation " +
            "FROM lessons " +
            "LEFT JOIN lesson_weekdays ON lessons.id = lesson_weekdays.lesson_id " +
            "LEFT JOIN week_days ON week_days.id = lesson_weekdays.weekday_id " +
            "LEFT JOIN lesson_subjects ON lessons.id = lesson_subjects.lesson_id " +
            "LEFT JOIN subjects ON subjects.id = lesson_subjects.subject_id")
    public abstract List<LessonWithFullInformationDataEntity> getAllLessonsWithFullInformation();

    @Query("SELECT " +
            "lessons.id, " +
            "lessons.start_time AS startTime, " +
            "lessons.end_time AS endTime," +
            "week_days.title AS weekDayTitle, " +
            "week_days.abbreviation AS weekDayAbbreviation, " +
            "subjects.title AS subjectTitle," +
            "subjects.abbreviation AS subjectAbbreviation, " +
            "cabinets.number AS cabinetNumber, " +
            "teachers.surname AS teacherSurname, " +
            "teachers.name AS teacherName, " +
            "teachers.patronymic AS teacherPatronymic, " +
            "types.title AS typeTitle, " +
            "types.abbreviation AS typeAbbreviation " +
            "FROM lessons " +
            "LEFT JOIN lesson_weekdays ON lessons.id = lesson_weekdays.lesson_id " +
            "LEFT JOIN week_days ON week_days.id = lesson_weekdays.weekday_id " +
            "LEFT JOIN lesson_subjects ON lessons.id = lesson_subjects.lesson_id " +
            "LEFT JOIN subjects ON subjects.id = lesson_subjects.subject_id " +
            "LEFT JOIN lesson_cabinets ON lessons.id = lesson_cabinets.lesson_id " +
            "LEFT JOIN cabinets ON cabinets.id = lesson_cabinets.cabinet_id " +
            "LEFT JOIN lesson_teachers ON lessons.id = lesson_teachers.lesson_id " +
            "LEFT JOIN teachers ON teachers.id = lesson_teachers.teacher_id " +
            "LEFT JOIN lesson_types ON lessons.id = lesson_types.lesson_id " +
            "LEFT JOIN types ON types.id = lesson_types.type_id " +
            "LEFT JOIN lessons_groups ON lessons.id = lessons_groups.lesson_id " +
            "LEFT JOIN groups ON groups.id = lessons_groups.group_id " +
            "WHERE groups.id = :groupId " +
            "ORDER BY start_time")
    public abstract List<LessonWithFullInformationDataEntity> getAllLessonsWithFullInformationByGroup(Long groupId);

    @Query("DELETE " +
            "FROM lessons_groups " +
            "WHERE lesson_id == :lessonId AND group_id =:groupId")
    public abstract void deleteLessonForGroup(Long lessonId, Long groupId);
}

