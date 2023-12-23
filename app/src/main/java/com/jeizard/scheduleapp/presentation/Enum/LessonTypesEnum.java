package com.jeizard.scheduleapp.presentation.Enum;

public enum LessonTypesEnum {
    LK("Лекция", "ЛК"),
    PZ("Практическое занятие", "ПЗ"),
    LR("Лабораторная работа", "ЛР");

    private final String title;
    private final String abbreviation;

    LessonTypesEnum(String title, String abbreviation) {
        this.title = title;
        this.abbreviation = abbreviation;
    }

    public String getTitle() {
        return title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
