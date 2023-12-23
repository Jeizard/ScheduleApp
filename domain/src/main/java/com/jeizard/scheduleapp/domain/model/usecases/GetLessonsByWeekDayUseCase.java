package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetLessonsByWeekDayUseCase {
    private List<LessonWithFullInformation> allLessonsWithWeekDay;
    private String weekDayAbbreviation;

    public GetLessonsByWeekDayUseCase(List<LessonWithFullInformation> allLessonsWithWeekDay, String weekDayAbbreviation) {
        this.allLessonsWithWeekDay = allLessonsWithWeekDay;
        this.weekDayAbbreviation = weekDayAbbreviation;
    }

    public List<LessonWithFullInformation> execute(){
        List<LessonWithFullInformation> allLessonsByWeekDay= new ArrayList<>();
        for(LessonWithFullInformation lessonWithWeekDay : allLessonsWithWeekDay){
            if(lessonWithWeekDay.getWeekDayAbbreviation().toLowerCase().contains(weekDayAbbreviation.toLowerCase())){
                allLessonsByWeekDay.add(lessonWithWeekDay);
            }
        }
        if(allLessonsByWeekDay.isEmpty()){
            return Collections.emptyList();
        }
        else{
            return allLessonsByWeekDay;
        }
    }
}
