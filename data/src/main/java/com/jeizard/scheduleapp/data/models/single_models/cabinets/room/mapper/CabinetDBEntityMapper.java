package com.jeizard.scheduleapp.data.models.single_models.cabinets.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity.CabinetDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Cabinet;
import com.jeizard.scheduleapp.domain.model.entities.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CabinetDBEntityMapper implements Mapper<CabinetDBEntity, Cabinet> {

    public CabinetDBEntityMapper() {
    }

    @Override
    public Cabinet mapFromDBEntity(CabinetDBEntity cabinetDBEntity) {
        Cabinet cabinet = null;
        if (cabinetDBEntity != null) {
            cabinet = new Cabinet(cabinetDBEntity.getId(), cabinetDBEntity.getNumber());
        }
        return cabinet;
    }

    @Override
    public CabinetDBEntity mapToDBEntity(Cabinet cabinet) {
        CabinetDBEntity cabinetDBEntity = null;
        if (cabinet != null) {
            cabinetDBEntity = new CabinetDBEntity(cabinet.getId(), cabinet.getNumber());
        }
        return cabinetDBEntity;
    }

    @Override
    public List<Cabinet> mapFromDBEntity(Collection<CabinetDBEntity> cabinetDBEntityCollection) {
        final List<Cabinet> cabinetList = new ArrayList<>();
        for (CabinetDBEntity cabinetDBEntity : cabinetDBEntityCollection) {
            final Cabinet cabinet = mapFromDBEntity(cabinetDBEntity);
            if (cabinet != null) {
                cabinetList.add(cabinet);
            }
        }
        return cabinetList;
    }

    @Override
    public List<CabinetDBEntity> mapToDBEntity(Collection<Cabinet> cabinetCollection) {
        final List<CabinetDBEntity> cabinetDBEntityList = new ArrayList<>();
        for (Cabinet cabinet : cabinetCollection) {
            final CabinetDBEntity cabinetDBEntity = mapToDBEntity(cabinet);
            if (cabinetDBEntity != null) {
                cabinetDBEntityList.add(cabinetDBEntity);
            }
        }
        return cabinetDBEntityList;
    }
}