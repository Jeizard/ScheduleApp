package com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.sql.Time;

@Entity(
        tableName = "lessons"
)
public class LessonDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "start_time")
    private Time startTime;

    @ColumnInfo(name = "end_time")
    private Time endTime;

    public LessonDBEntity(int id, Time startTime, Time endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}


