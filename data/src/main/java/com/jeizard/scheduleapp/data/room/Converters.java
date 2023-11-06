package com.jeizard.scheduleapp.data.room;

import androidx.room.TypeConverter;

import java.sql.Time;

public class Converters {
    @TypeConverter
    public static Time fromTimestamp(Long value) {
        return value == null ? null : new Time(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Time time) {
        return time == null ? null : time.getTime();
    }
}