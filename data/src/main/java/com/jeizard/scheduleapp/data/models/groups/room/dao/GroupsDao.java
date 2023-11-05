package com.jeizard.scheduleapp.data.models.groups.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.groups.room.entity.GroupDBEntity;

import java.util.List;

@Dao
public interface GroupsDao {

    @Insert
    void insert(GroupDBEntity groupDBEntity);

    @Update
    void update(GroupDBEntity groupDBEntity);

    @Delete
    void delete (GroupDBEntity groupDBEntity);

    @Query("DELETE FROM groups")
    void deleteAllGroups();

    @Query("SELECT * FROM groups")
    List<GroupDBEntity> getAllGroups();

    @Query("SELECT * " +
            "FROM groups " +
            "LEFT JOIN lesson_groups " +
            "ON groups.id = lesson_groups.group_id AND lesson_groups.lesson_id = :lessonId")
    List<GroupDBEntity> getGroupsByLesson(int lessonId);
}
