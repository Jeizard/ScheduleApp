package com.jeizard.scheduleapp.data.models.groups.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "groups"
)
public class GroupDBEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String number;

    public GroupDBEntity(int id, String number) {
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


