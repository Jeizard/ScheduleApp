package com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity.GroupSpecialtiesDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.entity.SpecialityFacultiesDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class SpecialityFacultiesDao implements BaseDao<SpecialityFacultiesDBEntity> {

    @Query("DELETE FROM speciality_faculties")
    public abstract void deleteAllSpecialityFaculties();

    @Query("SELECT * FROM speciality_faculties")
    public abstract List<SpecialityFacultiesDBEntity> getAllSpecialityFaculties();

    @Override
    public void deleteAll() {
        deleteAllSpecialityFaculties();
    }

    @Override
    public List<SpecialityFacultiesDBEntity> getAll() {
        return getAllSpecialityFaculties();
    }
}
