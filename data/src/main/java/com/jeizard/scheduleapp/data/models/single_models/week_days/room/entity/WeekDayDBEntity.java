package com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "week_days",
        indices = {
                @Index("title")
        }
)
public class WeekDayDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String abbreviation;

    public WeekDayDBEntity(int id, String title, String abbreviation) {
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


