package com.jeizard.scheduleapp.data.models.lessons.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.lessons.room.entity.LessonDBEntity;

import java.util.List;

@Dao
public interface LessonsDao {

    @Insert
    void insert(LessonDBEntity lessonDBEntity);

    @Update
    void update(LessonDBEntity lessonDBEntity);

    @Delete
    void delete (LessonDBEntity lessonDBEntity);

    @Query("DELETE FROM lessons")
    void deleteAllLessons();

    @Query("SELECT * FROM lessons")
    List<LessonDBEntity> getAllLessons();

    @Query("SELECT * " +
            "FROM lessons " +
            "LEFT JOIN lesson_groups " +
            "ON lessons.id = lesson_groups.lesson_id AND lesson_groups.group_id = :groupId")
    List<LessonDBEntity> getLessonsByGroup(int groupId);

    @Query("SELECT * " +
            "FROM lessons " +
            "LEFT JOIN lesson_teachers " +
            "ON lessons.id = lesson_teachers.lesson_id AND lesson_teachers.teacher_id = :teacherId")
    List<LessonDBEntity> getLessonsByTeacher(int teacherId);
}
