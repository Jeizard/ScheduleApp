package com.jeizard.scheduleapp.domain.model.repositories;

import com.jeizard.scheduleapp.domain.model.entities.Teacher;

import java.util.List;

public interface TeachersRepository {
    void insert(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);

    public void deleteAllTeachers();

    List<Teacher> getAllTeachers();
}
