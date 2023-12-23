package com.jeizard.scheduleapp.data.models.single_models.teachers.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class TeachersDao implements BaseDao<TeacherDBEntity> {


    @Query("DELETE FROM teachers")
    public abstract void deleteAllTeachers();

    @Query("SELECT * FROM teachers")
    public abstract List<TeacherDBEntity> getAllTeachers();

    @Override
    public void deleteAll() {
        deleteAllTeachers();
    }

    @Override
    public List<TeacherDBEntity> getAll() {
        return getAllTeachers();
    }
}
