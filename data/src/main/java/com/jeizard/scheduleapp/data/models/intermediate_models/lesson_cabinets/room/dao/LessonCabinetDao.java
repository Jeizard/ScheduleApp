package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.lesson_cabinets.room.entity.LessonCabinetDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class LessonCabinetDao implements BaseDao<LessonCabinetDBEntity> {

    @Query("DELETE FROM lesson_cabinets")
    public abstract void deleteAllLessonCabinets();

    @Query("SELECT * FROM lesson_cabinets")
    public abstract List<LessonCabinetDBEntity> getAllLessonCabinets();

    @Override
    public void deleteAll() {
        deleteAllLessonCabinets();
    }

    @Override
    public List<LessonCabinetDBEntity> getAll() {
        return getAllLessonCabinets();
    }
}
