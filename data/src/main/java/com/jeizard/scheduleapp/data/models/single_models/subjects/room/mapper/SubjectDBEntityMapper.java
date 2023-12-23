package com.jeizard.scheduleapp.data.models.single_models.subjects.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.subjects.room.entity.SubjectDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;
import com.jeizard.scheduleapp.domain.model.entities.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubjectDBEntityMapper implements Mapper<SubjectDBEntity, Subject> {

    public SubjectDBEntityMapper() {
    }

    @Override
    public Subject mapFromDBEntity(SubjectDBEntity subjectDBEntity) {
        Subject subject = null;
        if (subjectDBEntity != null) {
            subject = new Subject(subjectDBEntity.getId(), subjectDBEntity.getTitle(), subjectDBEntity.getAbbreviation());
        }
        return subject;
    }

    @Override
    public SubjectDBEntity mapToDBEntity(Subject subject) {
        SubjectDBEntity subjectDBEntity = null;
        if (subject != null) {
            subjectDBEntity = new SubjectDBEntity(subject.getId(), subject.getTitle(), subject.getAbbreviation());
        }
        return subjectDBEntity;
    }

    @Override
    public List<Subject> mapFromDBEntity(Collection<SubjectDBEntity> subjectDBEntityCollection) {
        final List<Subject> subjectList = new ArrayList<>();
        for (SubjectDBEntity subjectDBEntity : subjectDBEntityCollection) {
            final Subject subject = mapFromDBEntity(subjectDBEntity);
            if (subject != null) {
                subjectList.add(subject);
            }
        }
        return subjectList;
    }

    @Override
    public List<SubjectDBEntity> mapToDBEntity(Collection<Subject> subjectCollection) {
        final List<SubjectDBEntity> subjectDBEntityList = new ArrayList<>();
        for (Subject subject : subjectCollection) {
            final SubjectDBEntity subjectDBEntity = mapToDBEntity(subject);
            if (subjectDBEntity != null) {
                subjectDBEntityList.add(subjectDBEntity);
            }
        }
        return subjectDBEntityList;
    }
}