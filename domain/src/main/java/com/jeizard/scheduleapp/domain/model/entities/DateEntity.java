package com.jeizard.scheduleapp.domain.model.entities;

public class DateEntity {
    private String number;
    private String weekDay;
    private boolean isSelected;

    public DateEntity(String number, String weekDay, boolean isSelected) {
        this.number = number;
        this.weekDay = weekDay;
        this.isSelected = isSelected;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "number='" + number + '\'' +
                ", weekDay='" + weekDay + '\'' +
                '}';
    }
}
