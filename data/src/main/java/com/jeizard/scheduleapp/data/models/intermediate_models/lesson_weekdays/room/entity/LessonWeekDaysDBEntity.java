package com.jeizard.scheduleapp.data.models.intermediate_models.lesson_weekdays.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import com.jeizard.scheduleapp.data.models.single_models.lessons.room.entity.LessonDBEntity;
import com.jeizard.scheduleapp.data.models.single_models.week_days.room.entity.WeekDayDBEntity;

@Entity(
        tableName = "lesson_weekdays",
        primaryKeys = {"lesson_id", "weekday_id"},
        indices = {
                @Index("weekday_id")
        },
        foreignKeys = {
                @ForeignKey(
                        entity = LessonDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"lesson_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = WeekDayDBEntity.class,
                        parentColumns = {"id"},
                        childColumns = {"weekday_id"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }

)
public class LessonWeekDaysDBEntity {
    @NonNull
    @ColumnInfo(name = "lesson_id")
    private Long lessonId;
    @NonNull
    @ColumnInfo(name = "weekday_id")
    private Long weekdayId;

    public LessonWeekDaysDBEntity(Long lessonId, Long weekdayId) {
        this.lessonId = lessonId;
        this.weekdayId = weekdayId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getWeekdayId() {
        return weekdayId;
    }

    public void setWeekdayId(Long weekdayId) {
        this.weekdayId = weekdayId;
    }
}


