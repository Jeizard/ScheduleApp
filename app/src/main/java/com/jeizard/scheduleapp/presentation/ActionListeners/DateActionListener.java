package com.jeizard.scheduleapp.presentation.ActionListeners;

import com.jeizard.scheduleapp.domain.model.entities.DateEntity;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;

public interface DateActionListener {
    void onDateSelected(DateEntity dateEntity);
}
