package com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "education_forms"
)
public class EducationFormDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    public EducationFormDBEntity(int id, String title) {
        this.id = id;
        this.title = title;
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
}


