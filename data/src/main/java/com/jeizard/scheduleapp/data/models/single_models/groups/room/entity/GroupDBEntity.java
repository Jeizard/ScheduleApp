package com.jeizard.scheduleapp.data.models.single_models.groups.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "groups"
)
public class GroupDBEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String number;
    @ColumnInfo(name = "is_local")
    private Boolean isLocal;

    public GroupDBEntity(int id, String number, Boolean isLocal) {
        this.id = id;
        this.number = number;
        this.isLocal = isLocal;
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

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }
}


