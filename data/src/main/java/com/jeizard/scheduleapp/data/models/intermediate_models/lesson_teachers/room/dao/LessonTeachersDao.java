package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_teachers.room.entity.LessonTeachersDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonTeachersDao implements BaseDao<LessonTeachersDBEntity> {

    @Query("DELETE FROM lesson_teachers")
    public abstract void deleteAllLessonTeachers();

    @Query("SELECT * FROM lesson_teachers")
    public abstract List<LessonTeachersDBEntity> getAllLessonTeachers();

    @Override
    public void deleteAll() {
        deleteAllLessonTeachers();
    }

    @Override
    public List<LessonTeachersDBEntity> getAll() {
        return getAllLessonTeachers();
    }
}
