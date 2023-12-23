package com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "specialties"
)
public class SpecialityDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String abbreviation;

    public SpecialityDBEntity(int id, String title, String abbreviation) {
        this.id = id;
        this.title = title;
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}


