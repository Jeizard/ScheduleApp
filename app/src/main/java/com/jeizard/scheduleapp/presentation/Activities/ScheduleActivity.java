package com.jeizard.scheduleapp.presentation.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeizard.scheduleapp.R;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.presentation.Fragments.AddingLessonFragment;
import com.jeizard.scheduleapp.presentation.Fragments.AddingSchedulesByGroupsFragment;
import com.jeizard.scheduleapp.presentation.Fragments.CreatingGroupScheduleFragment;
import com.jeizard.scheduleapp.presentation.Fragments.DailyScheduleFragment;
import com.jeizard.scheduleapp.presentation.Fragments.LoginFragment;
import com.jeizard.scheduleapp.presentation.Fragments.RegisterFragment;
import com.jeizard.scheduleapp.presentation.Fragments.SelectingAddOptionFragment;
import com.jeizard.scheduleapp.presentation.Fragments.SelectingCreateOptionFragment;
import com.jeizard.scheduleapp.presentation.Fragments.SettingsAfterAuthFragment;
import com.jeizard.scheduleapp.presentation.Fragments.SettingsBeforeAuthFragment;
import com.jeizard.scheduleapp.presentation.Fragments.SidePanelFragment;

import java.lang.reflect.Type;

public class ScheduleActivity extends AppCompatActivity {
    private static final String TAG = "AddingSchedulesByGroupsActivity";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();
    private Group lastSelectedGroup;

    public Group getLastSelectedGroup() {
        return lastSelectedGroup;
    }

    public void setLastSelectedGroup(Group lastSelectedGroup) {
        this.lastSelectedGroup = lastSelectedGroup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedules_by_groups);

        this.sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();

        String json = sharedPreferences.getString("Last Selected Group", null);
        //editor.remove("Last Selected Group").commit();
        Type type = new TypeToken<Group>() {}.getType();
        Group lastSelectedGroup = gson.fromJson(json, type);
        if(lastSelectedGroup != null){
            this.lastSelectedGroup = lastSelectedGroup;
        }

        displayDailyScheduleFragment();
    }

    public void displaySidePanelFragment() {
        SidePanelFragment sidePanelFragment = new SidePanelFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, sidePanelFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayAddingSchedulesFragment() {
        AddingSchedulesByGroupsFragment addingSchedulesFragment = new AddingSchedulesByGroupsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, addingSchedulesFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayDailyScheduleFragment() {
        DailyScheduleFragment dailyScheduleFragment = new DailyScheduleFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, dailyScheduleFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayAddingLessonFragment() {
        AddingLessonFragment addingLessonFragment = new AddingLessonFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, addingLessonFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayEditingLessonFragment(LessonWithFullInformation selectedLesson) {
        AddingLessonFragment addingLessonFragment = new AddingLessonFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedLesson", selectedLesson);
        addingLessonFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, addingLessonFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displaySelectingAddOptionFragment() {
        SelectingAddOptionFragment selectingAddOptionFragment = new SelectingAddOptionFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, selectingAddOptionFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displaySelectingCreateOptionFragment() {
        SelectingCreateOptionFragment selectingCreateOptionFragment = new SelectingCreateOptionFragment();
        onBackPressed();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, selectingCreateOptionFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayCreatingGroupScheduleFragment() {
        CreatingGroupScheduleFragment creatingGroupScheduleFragment = new CreatingGroupScheduleFragment();
        onBackPressed();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, creatingGroupScheduleFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displaySettingsBeforeAuthFragment() {
        SettingsBeforeAuthFragment settingsBeforeAuthFragment = new SettingsBeforeAuthFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, settingsBeforeAuthFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displaySettingsAfterAuthFragment() {
        SettingsAfterAuthFragment settingsAfterAuthFragment = new SettingsAfterAuthFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, settingsAfterAuthFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginFragment)
                .addToBackStack(null)
                .commit();
    }

    public void displayRegisterFragment() {
        RegisterFragment registerFragment = new RegisterFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, registerFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 1) {
            moveTaskToBack(false);
        }
        else {
            super.onBackPressed();
        }
    }

    public void doubleBack(){
        onBackPressed();
        onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String json = gson.toJson(lastSelectedGroup);
        editor.putString("Last Selected Group", json);
        editor.apply();
    }
}