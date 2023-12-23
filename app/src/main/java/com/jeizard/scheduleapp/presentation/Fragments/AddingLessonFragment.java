package com.jeizard.scheduleapp.presentation.Fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jeizard.scheduleapp.R;
import com.jeizard.scheduleapp.databinding.FragmentAddingLessonBinding;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.domain.model.usecases.AddLessonToDBUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.CreateGroupLocalCopyUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.UpdateTrackedGroupUseCase;
import com.jeizard.scheduleapp.presentation.Adapters.LessonTypesAdapter;
import com.jeizard.scheduleapp.presentation.Adapters.WeekDaysAdapter;
import com.jeizard.scheduleapp.presentation.Enum.LessonTypesEnum;
import com.jeizard.scheduleapp.presentation.Enum.WeekDaysEnum;
import com.jeizard.scheduleapp.presentation.ViewModels.AddingSchedulesByGroupsViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.AddingSchedulesByGroupsViewModelFactory;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AddingLessonFragment extends Fragment {

    private FragmentAddingLessonBinding binding;
    LocalTime startTime = LocalTime.now();
    LocalTime endTime = startTime.plusHours(1).plusMinutes(20);
    private LessonWithFullInformation selectedLesson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentAddingLessonBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final WeekDaysEnum[] selectedDay = {WeekDaysEnum.MONDAY};
        final LessonTypesEnum[] selectedType = {LessonTypesEnum.LK};

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        AddingSchedulesByGroupsViewModel addingSchedulesByGroupsViewModel = new ViewModelProvider(getActivity(), new AddingSchedulesByGroupsViewModelFactory(getActivity().getApplication()))
                .get(AddingSchedulesByGroupsViewModel.class);

        binding.backButton.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        WeekDaysEnum[] daysOfWeek = WeekDaysEnum.values();
        WeekDaysAdapter adapter = new WeekDaysAdapter(this.getContext(), R.layout.item_spinner, daysOfWeek);
        binding.dayOfWeekSpinner.setAdapter(adapter);

        binding.dayOfWeekSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedDay[0] = daysOfWeek[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setStartTime();
        setEndTime();

        binding.startTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                startTime = LocalTime.of(hourOfDay, minute);
                                setStartTime();
                            }
                        },
                        startTime.getHour(),
                        startTime.getMinute(),
                        true);
                timePickerDialog.show();
            }
        });

        binding.endTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                LocalTime newEndTime = LocalTime.of(hourOfDay, minute);

                                if (newEndTime.isAfter(startTime)) {
                                    endTime = newEndTime;
                                    setEndTime();
                                } else {
                                    Toast.makeText(getContext(), "Время окончания пары должно быть позже, чем время её начала!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        endTime.getHour(),
                        endTime.getMinute(),
                        true);
                timePickerDialog.show();
            }
        });

        LessonTypesEnum[] lessonType = LessonTypesEnum.values();
        LessonTypesAdapter lessonTypesAdapter = new LessonTypesAdapter(this.getContext(), R.layout.item_spinner, lessonType);
        binding.lessonTypeSpinner.setAdapter(lessonTypesAdapter);

        binding.lessonTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedType[0] = lessonType[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        binding.doneButton.setOnClickListener(v -> {
            String title = String.valueOf(binding.title.getText());
            String subject = String.valueOf(binding.subject.getText());
            String teacher = String.valueOf(binding.teacher.getText());
            String cabinet = String.valueOf(binding.cabinet.getText());
            Time startTimeAsTime = new Time(startTime.toSecondOfDay() * 1000);
            Time endTimeAsTime = new Time(endTime.toSecondOfDay() * 1000);
            if(title.length() != 0) {
                LessonWithFullInformation lesson = new LessonWithFullInformation(0, startTimeAsTime, endTimeAsTime,
                        selectedDay[0].getFullName(), selectedDay[0].getAbbreviation(),
                        subject, title,
                        teacher, teacher, teacher,
                        cabinet,
                        selectedType[0].getTitle(), selectedType[0].getAbbreviation());
                if (!dailyScheduleViewModel.selectedGroup.getValue().getLocal()) {
                    addingSchedulesByGroupsViewModel.getGroupsRepository().addCopyGroupListener(dailyScheduleViewModel.getCopyGroupListener());

                    Observer<Group> groupObserver = new Observer<Group>() {
                        @Override
                        public void onChanged(Group selectedGroup) {
                            if (selectedGroup.getId() != 0 && selectedGroup.getLocal()) {
                                new UpdateTrackedGroupUseCase(dailyScheduleViewModel.getGroupsRepository()).execute(selectedGroup, dailyScheduleViewModel.getCurrentUserId());
                                new AddLessonToDBUseCase(lesson, selectedGroup.getId(), dailyScheduleViewModel.getLessonsWithFullInformationRepository()).execute();
                                dailyScheduleViewModel.selectedGroup.removeObserver(this);
                            }
                        }
                    };
                    dailyScheduleViewModel.selectedGroup.observe(getActivity(), groupObserver);

                    new CreateGroupLocalCopyUseCase(dailyScheduleViewModel.selectedGroup.getValue(), addingSchedulesByGroupsViewModel.getGroupsRepository()).execute(dailyScheduleViewModel.getCurrentUserId());
                    Toast.makeText(getContext(), "Создана локальная копия группы", Toast.LENGTH_SHORT).show();
                } else {
                    new AddLessonToDBUseCase(lesson, dailyScheduleViewModel.selectedGroup.getValue().getId(), dailyScheduleViewModel.getLessonsWithFullInformationRepository()).execute();
                }
                if (selectedLesson != null) {
                    dailyScheduleViewModel.getLessonsWithFullInformationRepository().deleteLessonForLocalGroup(selectedLesson.getId(), dailyScheduleViewModel.selectedGroup.getValue().getId());
                }
                getActivity().onBackPressed();
            }
            else{
                Toast.makeText(getContext(), "Введите название занятия!", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle args = getArguments();
        if (args != null && args.containsKey("selectedLesson")) {
            selectedLesson = (LessonWithFullInformation) args.getSerializable("selectedLesson");

            if (selectedLesson != null) {
                binding.title.setText(selectedLesson.getSubjectAbbreviation());
                binding.subject.setText(selectedLesson.getSubjectTitle());
                for (int i = 0; i < daysOfWeek.length; i++) {
                    if (daysOfWeek[i].getFullName().equals(selectedLesson.getWeekDayTitle())) {
                        binding.dayOfWeekSpinner.setSelection(i);
                        break;
                    }
                }
                startTime = LocalTime.parse(selectedLesson.getStartTime().toString());
                setStartTime();
                endTime = LocalTime.parse(selectedLesson.getEndTime().toString());
                setEndTime();
                binding.subject.setText(selectedLesson.getSubjectTitle());
                binding.teacher.setText(selectedLesson.getTeacherSurname() + " " +
                        selectedLesson.getTeacherName() + " " +
                        selectedLesson.getTeacherPatronymic());
                binding.cabinet.setText(selectedLesson.getCabinetNumber());
                for (int i = 0; i < lessonType.length; i++) {
                    if (lessonType[i].getTitle().equals(selectedLesson.getTypeTitle())) {
                        binding.lessonTypeSpinner.setSelection(i);
                        break;
                    }
                }
            }
        }
    }

    private void setStartTime() {
        binding.startTimeButton.setText(startTime.format(DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())));
    }

    private void setEndTime() {
        binding.endTimeButton.setText(endTime.format(DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())));
    }
}