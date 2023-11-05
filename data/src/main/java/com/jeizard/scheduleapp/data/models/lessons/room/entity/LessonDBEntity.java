package com.jeizard.scheduleapp.data.models.lessons.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.sql.Time;

@Entity(
        tableName = "lessons"
)
public class LessonDBEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "start_time")
    public Time startTime;

    @ColumnInfo(name = "end_time")
    public Time endTime;

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


