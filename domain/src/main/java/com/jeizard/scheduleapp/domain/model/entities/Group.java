package com.jeizard.scheduleapp.domain.model.entities;

public class Group {
    private int id;
    private String number;
    private Boolean isLocal;

    public Group(int id, String number, Boolean isLocal) {
        this.id = id;
        this.number = number;
        this.isLocal = isLocal;
    }

    public Group() {

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
