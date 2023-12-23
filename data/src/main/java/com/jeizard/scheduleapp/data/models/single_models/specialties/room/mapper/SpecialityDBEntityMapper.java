package com.jeizard.scheduleapp.data.models.single_models.specialties.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpecialityDBEntityMapper implements Mapper<SpecialityDBEntity, Speciality> {

    public SpecialityDBEntityMapper() {
    }

    @Override
    public Speciality mapFromDBEntity(SpecialityDBEntity specialityDBEntity) {
        Speciality speciality = null;
        if (specialityDBEntity != null) {
            speciality = new Speciality(specialityDBEntity.getId(), specialityDBEntity.getTitle(), specialityDBEntity.getAbbreviation());
        }
        return speciality;
    }

    @Override
    public SpecialityDBEntity mapToDBEntity(Speciality speciality) {
        SpecialityDBEntity specialityDBEntity = null;
        if (speciality != null) {
            specialityDBEntity = new SpecialityDBEntity(speciality.getId(), speciality.getTitle(), speciality.getAbbreviation());
        }
        return specialityDBEntity;
    }

    @Override
    public List<Speciality> mapFromDBEntity(Collection<SpecialityDBEntity> specialityDBEntityCollection) {
        final List<Speciality> specialityList = new ArrayList<>();
        for (SpecialityDBEntity specialityDBEntity : specialityDBEntityCollection) {
            final Speciality speciality = mapFromDBEntity(specialityDBEntity);
            if (speciality != null) {
                specialityList.add(speciality);
            }
        }
        return specialityList;
    }

    @Override
    public List<SpecialityDBEntity> mapToDBEntity(Collection<Speciality> specialityCollection) {
        final List<SpecialityDBEntity> specialityDBEntityList = new ArrayList<>();
        for (Speciality speciality : specialityCollection) {
            final SpecialityDBEntity specialityDBEntity = mapToDBEntity(speciality);
            if (specialityDBEntity != null) {
                specialityDBEntityList.add(specialityDBEntity);
            }
        }
        return specialityDBEntityList;
    }
}