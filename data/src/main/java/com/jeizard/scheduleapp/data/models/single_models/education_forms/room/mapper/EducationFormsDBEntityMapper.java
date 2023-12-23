package com.jeizard.scheduleapp.data.models.single_models.education_forms.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity.EducationFormDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.EducationForm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EducationFormsDBEntityMapper implements Mapper<EducationFormDBEntity, EducationForm> {

    public EducationFormsDBEntityMapper() {
    }

    @Override
    public EducationForm mapFromDBEntity(EducationFormDBEntity educationFormDBEntity) {
        EducationForm educationForm = null;
        if (educationFormDBEntity != null) {
            educationForm = new EducationForm(educationFormDBEntity.getId(), educationFormDBEntity.getTitle());
        }
        return educationForm;
    }

    @Override
    public EducationFormDBEntity mapToDBEntity(EducationForm educationForm) {
        EducationFormDBEntity educationFormDBEntity = null;
        if (educationForm != null) {
            educationFormDBEntity = new EducationFormDBEntity(educationForm.getId(), educationForm.getTitle());
        }
        return educationFormDBEntity;
    }

    @Override
    public List<EducationForm> mapFromDBEntity(Collection<EducationFormDBEntity> educationFormDBEntityCollection) {
        final List<EducationForm> educationFormList = new ArrayList<>();
        for (EducationFormDBEntity educationFormDBEntity : educationFormDBEntityCollection) {
            final EducationForm educationForm = mapFromDBEntity(educationFormDBEntity);
            if (educationForm != null) {
                educationFormList.add(educationForm);
            }
        }
        return educationFormList;
    }

    @Override
    public List<EducationFormDBEntity> mapToDBEntity(Collection<EducationForm> educationFormCollection) {
        final List<EducationFormDBEntity> educationFormDBEntityList = new ArrayList<>();
        for (EducationForm educationForm : educationFormCollection) {
            final EducationFormDBEntity educationFormDBEntity = mapToDBEntity(educationForm);
            if (educationFormDBEntity != null) {
                educationFormDBEntityList.add(educationFormDBEntity);
            }
        }
        return educationFormDBEntityList;
    }
}