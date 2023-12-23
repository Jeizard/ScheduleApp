package com.jeizard.scheduleapp.data.models.single_models.specialties.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;
import java.util.Map;

@Dao
public abstract class SpecialtiesDao implements BaseDao<SpecialityDBEntity> {


    @Query("DELETE FROM specialties")
    public abstract void deleteAllSpecialties();

    @Query("SELECT * FROM specialties")
    public abstract List<SpecialityDBEntity> getAllSpecialties();

    @Override
    public void deleteAll() {
        deleteAllSpecialties();
    }

    @Override
    public List<SpecialityDBEntity> getAll() {
        return getAllSpecialties();
    }
}
