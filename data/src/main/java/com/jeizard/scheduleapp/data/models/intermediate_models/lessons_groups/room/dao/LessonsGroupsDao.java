package com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonsGroupsDao implements BaseDao<LessonsGroupsDBEntity> {

    @Query("DELETE FROM lessons_groups")
    public abstract void deleteAllLessonsGroups();

    @Query("SELECT * FROM lessons_groups")
    public abstract List<LessonsGroupsDBEntity> getAllLessonsGroups();

    @Override
    public void deleteAll() {
        deleteAllLessonsGroups();
    }

    @Override
    public List<LessonsGroupsDBEntity> getAll() {
        return getAllLessonsGroups();
    }

    @Query("SELECT * " +
            "FROM lessons_groups " +
            "WHERE group_id = :groupId")
    public abstract List<LessonsGroupsDBEntity> getLessonsGroupsForGroup(int groupId);
}
