package com.jeizard.scheduleapp.data.models.teachers.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.teachers.room.entity.TeacherDBEntity;

import java.util.List;

@Dao
public interface TeachersDao {

    @Insert
    void insert(TeacherDBEntity teacherDBEntity);

    @Update
    void update(TeacherDBEntity teacherDBEntity);

    @Delete
    void delete (TeacherDBEntity teacherDBEntity);

    @Query("DELETE FROM teachers")
    void deleteAllTeachers();

    @Query("SELECT * FROM teachers")
    List<TeacherDBEntity> getAllTeachers();

    @Query("SELECT * " +
            "FROM teachers " +
            "LEFT JOIN lesson_teachers " +
            "ON teachers.id = lesson_teachers.teacher_id AND lesson_teachers.lesson_id = :lessonId")
    List<TeacherDBEntity> getTeachersByLesson(int lessonId);
}
