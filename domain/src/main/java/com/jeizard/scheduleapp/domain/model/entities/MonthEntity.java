package com.jeizard.scheduleapp.domain.model.entities;

public class MonthEntity {
    private String number;
    private String month;
    private String year;
    private boolean isSelected;

    public MonthEntity(String number, String month, String year, boolean isSelected) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.isSelected = isSelected;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "MonthEntity{" +
                "number='" + number + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
