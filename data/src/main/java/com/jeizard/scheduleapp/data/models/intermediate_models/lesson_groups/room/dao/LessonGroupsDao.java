package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_groups.room.entity.LessonGroupsDBEntity;

import java.util.List;

@Dao
public interface LessonGroupsDao {

    @Insert
    void insert(LessonGroupsDBEntity lessonGroupsDBEntity);

    @Update
    void update(LessonGroupsDBEntity lessonGroupsDBEntity);

    @Delete
    void delete (LessonGroupsDBEntity lessonGroupsDBEntity);

    @Query("DELETE FROM lesson_groups")
    void deleteAllLessonGroups();

    @Query("SELECT * FROM lesson_groups")
    List<LessonGroupsDBEntity> getAllLessonGroups();
}
