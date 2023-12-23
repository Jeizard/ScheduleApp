package com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.sharedpreferences.dao;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeizard.scheduleapp.data.models.composite_models.lesson_with_fullinformation.entity.LessonWithFullInformationDataEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LessonWithWeekDayDao {
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();


    public LessonWithWeekDayDao(Activity activity) {
        this.activity = activity;
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public List<LessonWithFullInformationDataEntity> loadByGroup(String groupNumber) {
        String json = sharedPreferences.getString(groupNumber, null);
        Type type = new TypeToken<ArrayList<LessonWithFullInformationDataEntity>>() {}.getType();
        List<LessonWithFullInformationDataEntity> lessonWithWeekDayDataEntityList = gson.fromJson(json, type);

        if(lessonWithWeekDayDataEntityList == null){
            lessonWithWeekDayDataEntityList = new ArrayList<>();
        }

        return lessonWithWeekDayDataEntityList;
    }

    public void saveByGroup(String groupNumber, List<LessonWithFullInformationDataEntity> lessonWithWeekDayDataEntityList) {
        String json = gson.toJson(lessonWithWeekDayDataEntityList);
        editor.putString(groupNumber, json);
        editor.apply();
    }

    public void insertByGroup(String groupNumber, LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity) {
        List<LessonWithFullInformationDataEntity> lessonWithWeekDayDataEntityList = loadByGroup(groupNumber);
        lessonWithWeekDayDataEntityList.add(lessonWithWeekDayDataEntity);
        saveByGroup(groupNumber, lessonWithWeekDayDataEntityList);
    }


    public void update(LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity) {

    }

    public void delete(LessonWithFullInformationDataEntity lessonWithWeekDayDataEntity) {

    }

    public void deleteAllLessonsWithWeekDay() {
        editor.remove(null).commit();
    }
}
