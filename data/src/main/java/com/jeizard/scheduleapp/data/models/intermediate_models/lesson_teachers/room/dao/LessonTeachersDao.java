package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;

import java.util.List;

@Dao
public interface LessonTeachersDao {

    @Insert
    void insert(LessonTeachersDBEntity lessonTeachersDBEntity);

    @Update
    void update(LessonTeachersDBEntity lessonTeachersDBEntity);

    @Delete
    void delete (LessonTeachersDBEntity lessonTeachersDBEntity);

    @Query("DELETE FROM lesson_teachers")
    void deleteAllLessonTeachers();

    @Query("SELECT * FROM lesson_teachers")
    List<LessonTeachersDBEntity> getAllLessonTeachers();
}
