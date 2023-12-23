package com.jeizard.scheduleapp.data.models.single_models.cabinets.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.data.room.dao.BaseDao;

import java.util.List;

@Dao
public abstract class CabinetDao implements BaseDao<CabinetDBEntity> {


    @Query("DELETE FROM cabinets")
    public abstract void deleteAllCabinets();

    @Query("SELECT * FROM cabinets")
    public abstract List<CabinetDBEntity> getAllCabinets();

    @Override
    public void deleteAll() {
        deleteAllCabinets();
    }

    @Override
    public List<CabinetDBEntity> getAll() {
        return getAllCabinets();
    }
}
