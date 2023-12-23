package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;

public class GetLessonsWithFullInformationByGroupUseCase {
    private Group group;
    private LessonsWithFullInformationRepository lessonsWithFullInformationRepository;

    public GetLessonsWithFullInformationByGroupUseCase(Group group, LessonsWithFullInformationRepository lessonsWithFullInformationRepository) {
        this.group = group;
        this.lessonsWithFullInformationRepository = lessonsWithFullInformationRepository;
    }

    public LessonWithFullInformation execute(){
        return null;
    }
}
