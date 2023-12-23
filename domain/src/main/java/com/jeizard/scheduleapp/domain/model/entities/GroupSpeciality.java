package com.jeizard.scheduleapp.domain.model.entities;

public class GroupSpeciality {
    private int groupId;
    private int specialityId;

    public GroupSpeciality(int groupId, int specialityId) {
        this.groupId = groupId;
        this.specialityId = specialityId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }
}


