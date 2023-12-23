package com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "study_years"
)
public class StudyYearDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String number;

    public StudyYearDBEntity(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}


