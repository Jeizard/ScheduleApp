package com.jeizard.scheduleapp.domain.model.entities;


public class Speciality {
    private int id;
    private String title;
    private String abbreviation;

    public Speciality(int id, String title, String abbreviation) {
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
