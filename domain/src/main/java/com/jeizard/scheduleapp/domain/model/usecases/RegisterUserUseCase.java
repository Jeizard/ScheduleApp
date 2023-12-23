package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.UserWithRole;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

public class RegisterUserUseCase {
    private BaseRepository<UserWithRole> userWithRoleRepository;

    public RegisterUserUseCase(BaseRepository<UserWithRole> userWithRoleRepository) {
        this.userWithRoleRepository = userWithRoleRepository;
    }

    public void execute(UserWithRole userWithRole){
        userWithRoleRepository.insert(userWithRole);
    }
}
