package com.jeizard.scheduleapp.data.models.teachers.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "teachers"
)
public class TeacherDBEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String surname;
    public String name;
    public String patronymic;

    public TeacherDBEntity(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}


