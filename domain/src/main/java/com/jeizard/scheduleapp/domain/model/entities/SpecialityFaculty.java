package com.jeizard.scheduleapp.domain.model.entities;

public class SpecialityFaculty {
    private int specialityId;
    private int facultyId;

    public SpecialityFaculty(int specialityId, int facultyId) {
        this.specialityId = specialityId;
        this.facultyId = facultyId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}


