package com.jeizard.scheduleapp.data.models.single_models.lessons.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonsDao implements BaseDao<LessonDBEntity> {
    @Query("DELETE FROM lessons")
    public abstract void deleteAllLessons();

    @Query("SELECT * FROM lessons")
    public abstract List<LessonDBEntity> getAllLessons();

    @Override
    public void deleteAll() {
        deleteAllLessons();
    }

    @Override
    public List<LessonDBEntity> getAll() {
        return getAllLessons();
    }

    @Query("SELECT * " +
            "FROM lessons " +
            "JOIN lessons_groups " +
            "ON lessons.id = lessons_groups.lesson_id AND lessons_groups.group_id = :groupId")
    public abstract List<LessonDBEntity> getLessonsByGroup(int groupId);
}
