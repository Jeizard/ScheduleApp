package com.jeizard.scheduleapp.domain.model.usecases;

import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetFilteredGroupWithSpecialityListUseCase {
    private List<GroupWithFullInformation> allGroupsWithSpecialties;
    private String textFilter;

    public GetFilteredGroupWithSpecialityListUseCase(List<GroupWithFullInformation> allGroupsWithSpecialties, String text) {
        this.allGroupsWithSpecialties = allGroupsWithSpecialties;
        this.textFilter = text;
    }

    public List<GroupWithFullInformation> execute(){
        List<GroupWithFullInformation> filteredGroupWithSpecialtiesList= new ArrayList<>();
        for(GroupWithFullInformation groupWithSpeciality : allGroupsWithSpecialties){
            if(groupWithSpeciality.getNumber().toLowerCase().contains(textFilter.toLowerCase())){
                filteredGroupWithSpecialtiesList.add(groupWithSpeciality);
            }
        }
        if(filteredGroupWithSpecialtiesList.isEmpty()){
            return Collections.emptyList();
        }
        else{
            return filteredGroupWithSpecialtiesList;
        }
    }
}
