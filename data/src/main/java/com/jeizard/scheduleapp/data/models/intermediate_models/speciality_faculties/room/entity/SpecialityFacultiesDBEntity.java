package com.jeizard.scheduleapp.data.models.intermediate_models.speciality_faculties.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.faculties.room.entity.FacultyDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.specialties.room.entity.SpecialityDBEntity;

@Entity(
        tableName = "speciality_faculties",
        primaryKeys = {"speciality_id", "faculty_id"},
        indices = {
                @Index("faculty_id")
        },
        foreignKeys = {
                @ForeignKey(
                        entity = SpecialityDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"speciality_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = FacultyDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"faculty_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class SpecialityFacultiesDBEntity {
    @ColumnInfo(name = "speciality_id")
    private int specialityId;
    @ColumnInfo(name = "faculty_id")
    private int facultyId;

    public SpecialityFacultiesDBEntity(int specialityId, int facultyId) {
        this.specialityId = specialityId;
        this.facultyId = facultyId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}


