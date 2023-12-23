package com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.jeizard.scheduleapp.data.models.composite_models.group_with_fullinformation.room.entity.GroupWithFullInformationDataEntity;

import java.util.List;

@Dao
public abstract class GroupsWithFullInformationDao {

    @Query("SELECT " +
            "groups.id, " +
            "groups.number, " +
            "groups.is_local AS isLocal, " +
            "specialties.title AS specialityTitle, " +
            "specialties.abbreviation AS specialityAbbreviation, " +
            "faculties.title AS facultyTitle, " +
            "faculties.abbreviation AS facultyAbbreviation, " +
            "study_years.number AS studyYearNumber, " +
            "education_forms.title AS educationFormTitle " +
            "FROM groups " +
            "LEFT JOIN group_specialties ON groups.id = group_specialties.group_id " +
            "LEFT JOIN specialties ON specialties.id = group_specialties.speciality_id " +
            "LEFT JOIN speciality_faculties ON specialties.id = speciality_faculties.speciality_id " +
            "LEFT JOIN faculties ON faculties.id = speciality_faculties.faculty_id " +
            "LEFT JOIN group_years_forms ON groups.id = group_years_forms.group_id " +
            "LEFT JOIN study_years ON study_years.id = group_years_forms.year_id " +
            "LEFT JOIN education_forms ON education_forms.id = group_years_forms.form_id " +
            "WHERE is_local = 0 " +
            "ORDER BY groups.number")
    public abstract List<GroupWithFullInformationDataEntity> getAllGroupsWithFullInformation();
}
