package com.jeizard.scheduleapp.domain.model.entities;

public class GroupYearsForms {
    private int groupId;
    private int yearId;
    private int formId;

    public GroupYearsForms(int groupId, int yearId, int formId) {
        this.groupId = groupId;
        this.yearId = yearId;
        this.formId = formId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }
}


