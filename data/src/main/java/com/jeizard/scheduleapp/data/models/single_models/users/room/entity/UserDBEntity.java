package com.jeizard.scheduleapp.data.models.single_models.users.room.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "users",
        indices = {@Index(value = "email", unique = true)}
)
public class UserDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String email;

    public UserDBEntity(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


