package com.jeizard.scheduleapp.data.models.single_models.education_forms.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity.EducationFormDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class EducationFormsDao implements BaseDao<EducationFormDBEntity> {

    @Query("DELETE FROM education_forms")
    public abstract void deleteAllEducationForms();

    @Query("SELECT * FROM education_forms")
    public abstract List<EducationFormDBEntity> getAllEducationForms();

    @Override
    public void deleteAll() {
        deleteAllEducationForms();
    }

    @Override
    public List<EducationFormDBEntity> getAll() {
        return getAllEducationForms();
    }
}
