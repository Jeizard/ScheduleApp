package com.jeizard.scheduleapp.data.models.single_models.cabinets.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "cabinets"
)
public class CabinetDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String number;

    public CabinetDBEntity(int id, String number) {
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


