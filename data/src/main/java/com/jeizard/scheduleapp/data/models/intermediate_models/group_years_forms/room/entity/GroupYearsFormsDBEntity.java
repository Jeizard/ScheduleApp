package com.jeizard.scheduleapp.data.models.intermediate_models.group_years_forms.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.study_years.room.entity.StudyYearDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.education_forms.room.entity.EducationFormDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;

@Entity(
        tableName = "group_years_forms",
        primaryKeys = {"group_id", "year_id", "form_id"},
        indices = {
                @Index("year_id"),
                @Index("form_id")
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
                        entity = StudyYearDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"year_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = EducationFormDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"form_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class GroupYearsFormsDBEntity {
    @ColumnInfo(name = "group_id")
    private int groupId;
    @ColumnInfo(name = "year_id")
    private int yearId;
    @ColumnInfo(name = "form_id")
    private int formId;

    public GroupYearsFormsDBEntity(int groupId, int yearId, int formId) {
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


