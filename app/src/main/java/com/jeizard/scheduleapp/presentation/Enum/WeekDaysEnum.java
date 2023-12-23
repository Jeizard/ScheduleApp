package com.jeizard.scheduleapp.presentation.Enum;

public enum WeekDaysEnum {
    MONDAY("Понедельник", "ПН"),
    TUESDAY("Вторник", "ВТ"),
    WEDNESDAY("Среда", "СР"),
    THURSDAY("Четверг", "ЧТ"),
    FRIDAY("Пятница", "ПТ"),
    SATURDAY("Суббота", "СБ"),
    SUNDAY("Воскресенье", "ВС");

    private final String fullName;
    private final String abbreviation;

    WeekDaysEnum(String fullName, String abbreviation) {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
