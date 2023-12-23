package com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.repository;

import android.app.Application;


import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.dao.LessonsGroupsDao;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.entity.LessonsGroupsDBEntity;
import com.jeizard.scheduleapp.data.models.intermediate_models.lessons_groups.room.mapper.LessonsGroupsDBEntityMapper;
import com.jeizard.scheduleapp.data.room.AppDatabase;
import com.jeizard.scheduleapp.data.room.repository.BaseRepositoryRoomImpl;
import com.jeizard.scheduleapp.domain.model.entities.LessonGroup;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class LessonsGroupsRepositoryRoomImpl extends BaseRepositoryRoomImpl<LessonsGroupsDBEntity, LessonsGroupsDao, LessonGroup> implements BaseRepository<LessonGroup> {
    private static final LessonsGroupsDBEntityMapper lessonsGroupsDBEntityMapper = new LessonsGroupsDBEntityMapper();

    public LessonsGroupsRepositoryRoomImpl(Application application) {
        super(AppDatabase.getInstance(application).lessonGroupsDao(), lessonsGroupsDBEntityMapper);
    }
}
