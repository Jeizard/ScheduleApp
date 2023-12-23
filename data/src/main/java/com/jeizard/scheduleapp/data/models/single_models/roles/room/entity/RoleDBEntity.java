package com.jeizard.scheduleapp.data.models.single_models.roles.room.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "roles",
        indices = {@Index(value = "name", unique = true)}
)
public class RoleDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public RoleDBEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


