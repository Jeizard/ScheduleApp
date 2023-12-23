package com.jeizard.scheduleapp.domain.model.repository;

import java.util.List;

public interface BaseRepository<Entity> {
    void insert(Entity item);
    void update(Entity item);
    void delete(Entity item);
    void deleteAll();
    List<Entity> getAll();

    interface OnDataChangedListener<Entity> {
        void onChanged(List<Entity> items);
    }

    void addListener(OnDataChangedListener<Entity> listener);
    void removeListener(OnDataChangedListener<Entity> listener);
}
