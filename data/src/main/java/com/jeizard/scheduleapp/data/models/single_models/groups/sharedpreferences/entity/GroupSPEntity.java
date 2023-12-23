package com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.entity;

public class GroupSPEntity {
    private int id;
    private String number;
    private Boolean isLocal;

    public GroupSPEntity(int id, String number, Boolean isLocal) {
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
