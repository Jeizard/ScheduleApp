package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.GroupSpeciality;
import com.jeizard.scheduleapp.domain.model.entities.Speciality;
import com.jeizard.scheduleapp.domain.model.repository.BaseRepository;

import java.util.List;

public class GetSpecialityByGroupUseCase {
    private Group group;
    private BaseRepository<Speciality> specialtiesRepository;
    private BaseRepository<GroupSpeciality> groupSpecialtiesRepository;

    public GetSpecialityByGroupUseCase(Group group, BaseRepository<Speciality> specialtiesRepository, BaseRepository<GroupSpeciality> groupSpecialtiesRepository) {
        this.group = group;
        this.specialtiesRepository = specialtiesRepository;
        this.groupSpecialtiesRepository = groupSpecialtiesRepository;
    }

    public Speciality execute(){
        List<Speciality> specialities = specialtiesRepository.getAll();
        List<GroupSpeciality> groupSpecialtiesList = groupSpecialtiesRepository.getAll();
        for(GroupSpeciality groupSpecialties : groupSpecialtiesList){
            if(groupSpecialties.getGroupId() == group.getId()){
                for(Speciality speciality : specialities){
                    if(speciality.getId() == groupSpecialties.getSpecialityId()){
                        return speciality;
                    }
                }
                return null;
            }
        }
        return null;
    }
}
