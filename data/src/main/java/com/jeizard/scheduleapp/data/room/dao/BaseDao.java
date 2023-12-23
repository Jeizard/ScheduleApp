package com.jeizard.scheduleapp.data.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Dao
public interface BaseDao<T> {
    @Insert
    long insert(T entity);

    @Update
    void update(T entity);

    @Delete
    void delete (T entity);

    @Query("")
    void deleteAll();

    @Query("")
    List<T> getAll();
}
