package com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.dao;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeizard.scheduleapp.data.models.single_models.groups.sharedpreferences.entity.GroupSPEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GroupsDao {
    private Activity activity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();


    public GroupsDao(Activity activity) {
        this.activity = activity;
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private List<GroupSPEntity> load() {
        String json = sharedPreferences.getString("Group List", null);
        Type type = new TypeToken<ArrayList<GroupSPEntity>>() {}.getType();
        List<GroupSPEntity> groupSPEntityList = gson.fromJson(json, type);

        if(groupSPEntityList == null){
            groupSPEntityList = new ArrayList<>();
        }

        return groupSPEntityList;
    }

    private void save(List<GroupSPEntity> groupSPEntityList) {
        String json = gson.toJson(groupSPEntityList);
        editor.putString("Group List", json);
        editor.apply();
    }

    public void insert(GroupSPEntity groupDBEntity) {
        List<GroupSPEntity> groupSPEntityList = load();

//        // Проверка наличия группы с тем же номером
//        boolean groupExists = groupSPEntityList.stream()
//                .anyMatch(existingGroup -> existingGroup.getNumber().equals(groupDBEntity.getNumber()));
//
//        if (!groupExists) {
//            groupSPEntityList.add(groupDBEntity);
//            save(groupSPEntityList);
//        }

        groupSPEntityList.add(groupDBEntity);
        save(groupSPEntityList);
    }


    public int update(GroupSPEntity groupSPEntity) {
        int lastId = 0;
        List<GroupSPEntity> groupSPEntityList = load();
        for (int i = 0; i < groupSPEntityList.size(); i++) {
            GroupSPEntity group = groupSPEntityList.get(i);
            if (group.getNumber().equals(groupSPEntity.getNumber())) {
                lastId = groupSPEntityList.get(i).getId();
                groupSPEntityList.set(i, new GroupSPEntity(
                        groupSPEntity.getId(),
                        groupSPEntity.getNumber(),
                        groupSPEntity.getLocal()
                ));
                break;
            }
        }
        save(groupSPEntityList);
        return lastId;
    }

    public void delete(GroupSPEntity groupSPEntity) {
        List<GroupSPEntity> groupSPEntityList = load();
        groupSPEntityList.removeIf(group -> group.getNumber().equals(groupSPEntity.getNumber())); //по Number?
        save(groupSPEntityList);
    }

    public void deleteAllGroups() {
        editor.remove("Group List").commit();
    }

    public List<GroupSPEntity> getAllGroups() {
        List<GroupSPEntity> groupSPEntityList = load();
        return  groupSPEntityList;
    }
}
