package com.jeizard.scheduleapp.domain.model.entities;

import java.io.Serializable;
import java.sql.Time;

public class LessonWithFullInformation implements Serializable {
    private int id;
    private Time startTime;
    private Time endTime;
    private String weekDayTitle;
    private String weekDayAbbreviation;
    private String subjectTitle;
    private String subjectAbbreviation;
    private String teacherSurname;
    private String teacherName;
    private String teacherPatronymic;
    private String cabinetNumber;
    private String typeTitle;
    private String typeAbbreviation;


    public LessonWithFullInformation(int id, Time startTime, Time endTime, String weekDayTitle, String weekDayAbbreviation, String subjectTitle, String subjectAbbreviation, String teacherSurname, String teacherName, String teacherPatronymic, String cabinetNumber, String typeTitle, String typeAbbreviation) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDayTitle = weekDayTitle;
        this.weekDayAbbreviation = weekDayAbbreviation;
        this.subjectTitle = subjectTitle;
        this.subjectAbbreviation = subjectAbbreviation;
        this.teacherSurname = teacherSurname;
        this.teacherName = teacherName;
        this.teacherPatronymic = teacherPatronymic;
        this.cabinetNumber = cabinetNumber;
        this.typeTitle = typeTitle;
        this.typeAbbreviation = typeAbbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getWeekDayTitle() {
        return weekDayTitle;
    }

    public void setWeekDayTitle(String weekDayTitle) {
        this.weekDayTitle = weekDayTitle;
    }

    public String getWeekDayAbbreviation() {
        return weekDayAbbreviation;
    }

    public void setWeekDayAbbreviation(String weekDayAbbreviation) {
        this.weekDayAbbreviation = weekDayAbbreviation;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectAbbreviation() {
        return subjectAbbreviation;
    }

    public void setSubjectAbbreviation(String subjectAbbreviation) {
        this.subjectAbbreviation = subjectAbbreviation;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPatronymic() {
        return teacherPatronymic;
    }

    public void setTeacherPatronymic(String teacherPatronymic) {
        this.teacherPatronymic = teacherPatronymic;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public String getTypeAbbreviation() {
        return typeAbbreviation;
    }

    public void setTypeAbbreviation(String typeAbbreviation) {
        this.typeAbbreviation = typeAbbreviation;
    }
}
