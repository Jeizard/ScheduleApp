package com.jeizard.scheduleapp.data.models.single_models.teachers.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.teachers.room.entity.TeacherDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.Teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeacherDBEntityMapper implements Mapper<TeacherDBEntity, Teacher> {

    public TeacherDBEntityMapper() {
    }

    @Override
    public Teacher mapFromDBEntity(TeacherDBEntity teacherDBEntity) {
        Teacher teacher = null;
        if (teacherDBEntity != null) {
            teacher = new Teacher(teacherDBEntity.getId(), teacherDBEntity.getSurname(), teacherDBEntity.getName(), teacherDBEntity.getPatronymic());
        }
        return teacher;
    }

    @Override
    public TeacherDBEntity mapToDBEntity(Teacher teacher) {
        TeacherDBEntity teacherDBEntity = null;
        if (teacher != null) {
            teacherDBEntity = new TeacherDBEntity(teacher.getId(), teacher.getSurname(), teacher.getName(), teacher.getPatronymic());
        }
        return teacherDBEntity;
    }

    @Override
    public List<Teacher> mapFromDBEntity(Collection<TeacherDBEntity> teacherDBEntityCollection) {
        final List<Teacher> teacherList = new ArrayList<>();
        for (TeacherDBEntity teacherDBEntity : teacherDBEntityCollection) {
            final Teacher teacher = mapFromDBEntity(teacherDBEntity);
            if (teacher != null) {
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }

    @Override
    public List<TeacherDBEntity> mapToDBEntity(Collection<Teacher> teacherCollection) {
        final List<TeacherDBEntity> teacherDBEntityList = new ArrayList<>();
        for (Teacher teacher : teacherCollection) {
            final TeacherDBEntity teacherDBEntity = mapToDBEntity(teacher);
            if (teacherDBEntity != null) {
                teacherDBEntityList.add(teacherDBEntity);
            }
        }
        return teacherDBEntityList;
    }
}