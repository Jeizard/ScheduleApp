package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.domain.model.repository.LessonsWithFullInformationRepository;

public class AddLessonToDBUseCase {
    private LessonWithFullInformation lesson;
    private int groupId;
    private LessonsWithFullInformationRepository lessonsWithFullInformationRepository;

    public AddLessonToDBUseCase(LessonWithFullInformation lesson, int groupId, LessonsWithFullInformationRepository lessonsWithFullInformationRepository) {
        this.lesson = lesson;
        this.groupId = groupId;
        this.lessonsWithFullInformationRepository = lessonsWithFullInformationRepository;
    }

    public void execute(){
        lessonsWithFullInformationRepository.insertLessonsByGroup(lesson, groupId);
    }
}
