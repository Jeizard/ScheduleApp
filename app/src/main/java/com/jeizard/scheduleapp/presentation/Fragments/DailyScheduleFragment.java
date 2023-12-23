package com.jeizard.scheduleapp.presentation.Fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jeizard.scheduleapp.R;
import com.jeizard.scheduleapp.data.models.single_models.groups.room.entity.GroupDBEntity;
import com.jeizard.scheduleapp.databinding.FragmentDailyScheduleBinding;
import com.jeizard.scheduleapp.domain.model.entities.DateEntity;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.MonthEntity;
import com.jeizard.scheduleapp.domain.model.entities.User;
import com.jeizard.scheduleapp.domain.model.usecases.CreateGroupLocalCopyUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.GetLessonsByWeekDayUseCase;
import com.jeizard.scheduleapp.domain.model.usecases.UpdateTrackedGroupUseCase;
import com.jeizard.scheduleapp.presentation.ActionListeners.DateActionListener;
import com.jeizard.scheduleapp.presentation.ActionListeners.MonthActionListener;
import com.jeizard.scheduleapp.presentation.ActionListeners.OnSwipeTouchListener;
import com.jeizard.scheduleapp.presentation.Activities.ScheduleActivity;
import com.jeizard.scheduleapp.presentation.Adapters.DateAdapter;
import com.jeizard.scheduleapp.presentation.Adapters.LessonAdapter;
import com.jeizard.scheduleapp.presentation.Adapters.MonthAdapter;
import com.jeizard.scheduleapp.presentation.ViewModels.AddingSchedulesByGroupsViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.AddingSchedulesByGroupsViewModelFactory;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

import java.util.Calendar;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DailyScheduleFragment extends Fragment {

    private FragmentDailyScheduleBinding binding;
    private DateAdapter dateAdapter;
    private MonthAdapter monthAdapter;
    private LessonAdapter lessonAdapter;
    private Group selectedGroup;

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
        if (scheduleActivity != null) {
            selectedGroup = scheduleActivity.getLastSelectedGroup();
            if(selectedGroup == null){
                selectedGroup = new Group();
            }
        }
        else{
            selectedGroup = new Group();
        }

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(getContext(), "Пользователь авторизован", Toast.LENGTH_SHORT).show();
        }

        binding = FragmentDailyScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);
        AddingSchedulesByGroupsViewModel addingSchedulesByGroupsViewModel = new ViewModelProvider(getActivity(), new AddingSchedulesByGroupsViewModelFactory(getActivity().getApplication()))
                .get(AddingSchedulesByGroupsViewModel.class);
        switch (item.getItemId()) {
            case 1:
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.displayEditingLessonFragment(lessonAdapter.selectedLesson);
                }

                break;
            case 2:
                if (!dailyScheduleViewModel.selectedGroup.getValue().getLocal()) {
                    addingSchedulesByGroupsViewModel.getGroupsRepository().addCopyGroupListener(dailyScheduleViewModel.getCopyGroupListener());

                    Observer<Group> groupObserver = new Observer<Group>() {
                        @Override
                        public void onChanged(Group selectedGroup) {
                            if (selectedGroup.getId() != 0 && selectedGroup.getLocal()) {
                                new UpdateTrackedGroupUseCase(dailyScheduleViewModel.getGroupsRepository()).execute(selectedGroup, dailyScheduleViewModel.getCurrentUserId());
                                dailyScheduleViewModel.getLessonsWithFullInformationRepository().deleteLessonForLocalGroup(lessonAdapter.selectedLesson.getId(), dailyScheduleViewModel.selectedGroup.getValue().getId()); //засунуть в usecase?
                                dailyScheduleViewModel.selectedGroup.removeObserver(this);
                            }
                        }
                    };
                    dailyScheduleViewModel.selectedGroup.observe(getActivity(), groupObserver);

                    new CreateGroupLocalCopyUseCase(dailyScheduleViewModel.selectedGroup.getValue(), addingSchedulesByGroupsViewModel.getGroupsRepository()).execute(dailyScheduleViewModel.getCurrentUserId());
                    Toast.makeText(getContext(), "Создана локальная копия группы", Toast.LENGTH_SHORT).show();
                }
                else{
                    dailyScheduleViewModel.getLessonsWithFullInformationRepository().deleteLessonForLocalGroup(lessonAdapter.selectedLesson.getId(), dailyScheduleViewModel.selectedGroup.getValue().getId()); //засунуть в usecase?
                }
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.lessonsRecyclerView.setOnTouchListener(new OnSwipeTouchListener(getContext()){
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                if(!(monthAdapter.getSelectedMonth() == dateAdapter.getCurrentMonth())){
                    monthAdapter.getActionListener().onMonthSelected(monthAdapter.getMonths().get(monthAdapter.getCurrentMonth() - 1));
                }
                int currentDate = dateAdapter.getCurrentDate();
                if (currentDate < dateAdapter.getDates().size()) {
                    DateEntity date = dateAdapter.getDates().get(currentDate);
                    dateAdapter.getActionListener().onDateSelected(date);
                } else {
                    int selectedMonth = monthAdapter.getSelectedMonth();
                    if (selectedMonth < monthAdapter.getMonths().size()) {
                        MonthEntity month = monthAdapter.getMonths().get(selectedMonth);
                        monthAdapter.getActionListener().onMonthSelected(month);
                        DateEntity date = dateAdapter.getDates().get(0);
                        dateAdapter.getActionListener().onDateSelected(date);
                    }
                }
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();

                if(!(monthAdapter.getSelectedMonth() == dateAdapter.getCurrentMonth())){
                    monthAdapter.getActionListener().onMonthSelected(monthAdapter.getMonths().get(monthAdapter.getCurrentMonth() - 1));
                }
                int currentDate = dateAdapter.getCurrentDate();
                if (currentDate > 1) {
                    DateEntity date = dateAdapter.getDates().get(currentDate - 2);
                    dateAdapter.getActionListener().onDateSelected(date);
                } else {
                    int selectedMonth = monthAdapter.getSelectedMonth();
                    if (selectedMonth > 0) {
                        MonthEntity month = monthAdapter.getMonths().get(selectedMonth - 2);
                        monthAdapter.getActionListener().onMonthSelected(month);
                        DateEntity date = dateAdapter.getDates().get(dateAdapter.getDates().size() - 1);
                        dateAdapter.getActionListener().onDateSelected(date);
                    }
                }
            }
        });

        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(binding.datesRecyclerView.getContext()) {
            private static final float MILLISECONDS_PER_INCH = 300f; // Установка скорости скролла

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };

        RecyclerView.SmoothScroller smoothScrollerForMonth = new LinearSmoothScroller(binding.monthRecyclerView.getContext()) {
            private static final float MILLISECONDS_PER_INCH = 300f; // Установка скорости скролла

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };

        DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider(getActivity(),
                new DailyScheduleViewModelFactory(getActivity(), getActivity().getApplication()))
                .get(DailyScheduleViewModel.class);

        lessonAdapter = new LessonAdapter();

        monthAdapter = new MonthAdapter(new MonthActionListener() {
            @Override
            public void onMonthSelected(MonthEntity selectedMonthEntity) {
                List<MonthEntity> months = monthAdapter.getMonths();
                months.forEach(monthEntity -> {
                    if(monthEntity.equals(selectedMonthEntity)){
                        monthEntity.setSelected(true);
                        monthAdapter.setSelectedMonth(Integer.parseInt(monthEntity.getNumber()));
                        dateAdapter.setSelectedMonth(Integer.parseInt(monthEntity.getNumber()));
                        if(dateAdapter.getSelectedMonth() == dateAdapter.getCurrentMonth()){
                            smoothScroller.setTargetPosition(dateAdapter.getCurrentDate() - 1);
                        }
                        else {
                            smoothScroller.setTargetPosition(0);
                        }
                        binding.datesRecyclerView.getLayoutManager().startSmoothScroll(smoothScroller);
                    }
                    else{
                        monthEntity.setSelected(false);
                    }
                });
                monthAdapter.setMonths(months);

                smoothScrollerForMonth.setTargetPosition(Integer.parseInt(selectedMonthEntity.getNumber()) - 1);
                binding.monthRecyclerView.getLayoutManager().startSmoothScroll(smoothScrollerForMonth);

                if(monthAdapter.getSelectedMonth() != monthAdapter.getCurrentMonth()){
                    binding.menuButton.setImageResource(R.drawable.ic_back);
                }
                else{
                    binding.menuButton.setImageResource(R.drawable.ic_menu);
                }
            }
        });
        dateAdapter = new DateAdapter(new DateActionListener() {
            @Override
            public void onDateSelected(DateEntity selectedDateEntity) {
                List<DateEntity> dates = dateAdapter.getDates();
                dates.forEach(dateEntity -> {
                    if(dateEntity.equals(selectedDateEntity)){
                        dateEntity.setSelected(true);
                        dateAdapter.setCurrentDate(Integer.parseInt(dateEntity.getNumber()));
                        dateAdapter.setCurrentMonth(monthAdapter.getSelectedMonth());
                        lessonAdapter.setLessonList(new GetLessonsByWeekDayUseCase(dailyScheduleViewModel.allLessonsWithFullInformationForSelectedGroup.getValue(), dateEntity.getWeekDay()).execute());
                    }
                    else{
                        dateEntity.setSelected(false);
                    }
                });
                dateAdapter.setDates(dates);

                smoothScroller.setTargetPosition(Integer.parseInt(selectedDateEntity.getNumber()) - 1);
                binding.datesRecyclerView.getLayoutManager().startSmoothScroll(smoothScroller);
                // binding.recyclerView.smoothScrollToPosition(Integer.parseInt(selectedDateEntity.getNumber()) - 1);

                if(dateAdapter.getCurrentDate() != dateAdapter.getTodayDate()){
                    binding.menuButton.setImageResource(R.drawable.ic_back);
                }
                else{
                    openDatePicker();
                    binding.menuButton.setImageResource(R.drawable.ic_menu);
                }
            }
        });

        binding.menuButton.setOnClickListener(v -> {
            if(dateAdapter.getTodayDate() == dateAdapter.getCurrentDate() && monthAdapter.getSelectedMonth() == monthAdapter.getCurrentMonth()) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    scheduleActivity.displaySidePanelFragment();
                }
            }
            else{
                monthAdapter.setToCurrent();
                dateAdapter.setToCurrent();
            }
        });

        binding.addButton.setOnClickListener(v -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.displayAddingLessonFragment();
            }
        });

        dailyScheduleViewModel.setSelectedGroup(selectedGroup);

        dailyScheduleViewModel.selectedGroup.observe(getActivity(), selectedGroup -> {
            ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
            if (scheduleActivity != null) {
                scheduleActivity.setLastSelectedGroup(selectedGroup);
            }
        });

//        dailyScheduleViewModel.allLessonsWithWeekDayForSelectedGroup.observe(getActivity(),
//                lessonWithWeekDays -> { lessonAdapter.setLessonList(lessonWithWeekDays);
//                binding.lessonsRecyclerView.setAdapter(lessonAdapter);});

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.datesRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.datesRecyclerView.setLayoutManager(linearLayoutManager);

        SnapHelper snapHelperForMonth = new LinearSnapHelper();
        snapHelperForMonth.attachToRecyclerView(binding.monthRecyclerView);

        LinearLayoutManager linearLayoutManagerForMonth = new LinearLayoutManager(this.getContext());
        linearLayoutManagerForMonth.setOrientation(linearLayoutManagerForMonth.HORIZONTAL);
        binding.monthRecyclerView.setLayoutManager(linearLayoutManagerForMonth);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;

        int itemDateWidth = 200;
        int itemMonthWidth = 400;

        int paddingDay = (screenWidth / 2) - (itemDateWidth / 2);
        int paddingMonth = (screenWidth / 2) - (itemMonthWidth / 2);

        binding.datesRecyclerView.setPadding(paddingDay, 0, paddingDay, 0);
        binding.datesRecyclerView.setClipToPadding(false);
        binding.monthRecyclerView.setPadding(paddingMonth, 0, paddingMonth, 0);
        binding.monthRecyclerView.setClipToPadding(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        binding.lessonsRecyclerView.setLayoutManager(layoutManager);

        binding.monthRecyclerView.setAdapter(monthAdapter);
        binding.datesRecyclerView.setAdapter(dateAdapter);
        binding.lessonsRecyclerView.setAdapter(lessonAdapter);

        binding.datesRecyclerView.smoothScrollToPosition(dateAdapter.getCurrentDate() - 1);
        binding.monthRecyclerView.smoothScrollToPosition(monthAdapter.getSelectedMonth() - 1);

        dailyScheduleViewModel.allLessonsWithFullInformationForSelectedGroup.observe(getActivity(), lessonWithFullInformations -> {
            lessonAdapter.setLessonList(new GetLessonsByWeekDayUseCase(lessonWithFullInformations, dateAdapter.getDates().get(dateAdapter.getCurrentDate() - 1).getWeekDay()).execute());
        });

        binding.settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity scheduleActivity = (ScheduleActivity) getActivity();
                if (scheduleActivity != null) {
                    if(mAuth.getCurrentUser() != null){
                        scheduleActivity.displaySettingsAfterAuthFragment();
                    }
                    else {
                        scheduleActivity.displaySettingsBeforeAuthFragment();
                    }
                }
            }
        });
    }

    private void openDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                (view, year, month, dayOfMonth) -> {
                    monthAdapter.getActionListener().onMonthSelected(monthAdapter.getMonths().get(month));
                    dateAdapter.getActionListener().onDateSelected(dateAdapter.getDates().get(dayOfMonth - 1));
                },
                monthAdapter.getCurrentYear(),
                dateAdapter.getCurrentMonth() - 1,
                dateAdapter.getCurrentDate()
        );
        datePickerDialog.show();
    }
}