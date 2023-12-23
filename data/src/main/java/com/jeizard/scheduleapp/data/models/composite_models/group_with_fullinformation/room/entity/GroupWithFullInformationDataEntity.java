package com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.entity;

public class GroupWithFullInformationDataEntity {
    private int id;
    private String number;
    private Boolean isLocal;
    private String specialityTitle;
    private String specialityAbbreviation;
    private String facultyTitle;
    private String facultyAbbreviation;
    private String studyYearNumber;
    private String educationFormTitle;

    public GroupWithFullInformationDataEntity(int id, String number, Boolean isLocal, String specialityTitle, String specialityAbbreviation, String facultyTitle, String facultyAbbreviation, String studyYearNumber, String educationFormTitle) {
        this.id = id;
        this.number = number;
        this.isLocal = isLocal;
        this.specialityTitle = specialityTitle;
        this.specialityAbbreviation = specialityAbbreviation;
        this.facultyTitle = facultyTitle;
        this.facultyAbbreviation = facultyAbbreviation;
        this.studyYearNumber = studyYearNumber;
        this.educationFormTitle = educationFormTitle;
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

    public String getSpecialityTitle() {
        return specialityTitle;
    }

    public void setSpecialityTitle(String specialityTitle) {
        this.specialityTitle = specialityTitle;
    }

    public String getSpecialityAbbreviation() {
        return specialityAbbreviation;
    }

    public void setSpecialityAbbreviation(String specialityAbbreviation) {
        this.specialityAbbreviation = specialityAbbreviation;
    }

    public String getFacultyTitle() {
        return facultyTitle;
    }

    public void setFacultyTitle(String facultyTitle) {
        this.facultyTitle = facultyTitle;
    }

    public String getFacultyAbbreviation() {
        return facultyAbbreviation;
    }

    public void setFacultyAbbreviation(String facultyAbbreviation) {
        this.facultyAbbreviation = facultyAbbreviation;
    }

    public String getStudyYearNumber() {
        return studyYearNumber;
    }

    public void setStudyYearNumber(String studyYearNumber) {
        this.studyYearNumber = studyYearNumber;
    }

    public String getEducationFormTitle() {
        return educationFormTitle;
    }

    public void setEducationFormTitle(String educationFormTitle) {
        this.educationFormTitle = educationFormTitle;
    }
}
