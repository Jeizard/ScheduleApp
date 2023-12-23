package com.jeizard.scheduleapp.data.models.single_models.users.room.mapper;

import com.jeizard.scheduleapp.data.mapper.Mapper;
import com.jeizard.scheduleapp.data.models.single_models.users.room.entity.UserDBEntity;
import com.jeizard.scheduleapp.domain.model.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDBEntityMapper implements Mapper<UserDBEntity, User> {


    public UserDBEntityMapper() {
    }

    @Override
    public User mapFromDBEntity(UserDBEntity userDBEntity) {
        User user = null;
        if (userDBEntity != null) {
            user = new User(userDBEntity.getId(), userDBEntity.getEmail());
        }
        return user;
    }

    @Override
    public UserDBEntity mapToDBEntity(User user) {
        UserDBEntity userDBEntity = null;
        if (user != null) {
            userDBEntity = new UserDBEntity(user.getId(), user.getEmail());
        }
        return userDBEntity;
    }

    @Override
    public List<User> mapFromDBEntity(Collection<UserDBEntity> userDBEntityCollection) {
        final List<User> userList = new ArrayList<>();
        for (UserDBEntity userDBEntity : userDBEntityCollection) {
            final User user = mapFromDBEntity(userDBEntity);
            if (user != null) {
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public List<UserDBEntity> mapToDBEntity(Collection<User> userCollection) {
        final List<UserDBEntity> userDBEntityList = new ArrayList<>();
        for (User user : userCollection) {
            final UserDBEntity userDBEntity = mapToDBEntity(user);
            if (userDBEntity != null) {
                userDBEntityList.add(userDBEntity);
            }
        }
        return userDBEntityList;
    }
}