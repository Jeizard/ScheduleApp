package com.jeizard.scheduleapp.data.models.intermediate_models.group_specialties.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;

@Entity(
        tableName = "group_specialties",
        primaryKeys = {"group_id", "speciality_id"},
        indices = {
                @Index("speciality_id")
        },
        foreignKeys = {
                @ForeignKey(
                        entity = GroupDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"group_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = SpecialityDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"speciality_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class GroupSpecialtiesDBEntity {
    @ColumnInfo(name = "group_id")
    private int groupId;
    @ColumnInfo(name = "speciality_id")
    private int specialityId;

    public GroupSpecialtiesDBEntity(int groupId, int specialityId) {
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


