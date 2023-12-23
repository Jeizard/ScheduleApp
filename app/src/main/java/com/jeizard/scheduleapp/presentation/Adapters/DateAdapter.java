package com.jeizard.scheduleapp.presentation.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeizard.scheduleapp.databinding.ItemDateBinding;
import com.jeizard.scheduleapp.domain.model.entities.DateEntity;
import com.jeizard.scheduleapp.presentation.ActionListeners.DateActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> implements View.OnClickListener{

    private DateActionListener actionListener;
    Calendar calendar = Calendar.getInstance();
    Locale russianLocale = new Locale("ru", "RU");
    int todayDate = Integer.parseInt(new SimpleDateFormat("dd").format(calendar.getTime()));
    int currentDate = todayDate;

    int currentMonth = calendar.get(Calendar.MONTH) + 1;
    Integer currentYear = calendar.get(Calendar.YEAR);
    int selectedMonth = currentMonth;
    int selectedYear = currentYear;

    private List<DateEntity> dates = new ArrayList<>();

    public DateAdapter(DateActionListener actionListener) {
        calendar.set(selectedYear, selectedMonth - 1, 1);
        int monthSize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(Integer i = 1; i <= monthSize; i++){
            calendar.set(selectedYear, selectedMonth - 1, i);
            String weekDay = new SimpleDateFormat("EE", russianLocale).format(calendar.getTime()).toUpperCase();
            if(i == currentDate){
                dates.add(new DateEntity(i.toString(), weekDay, true));
            }
            else {
                dates.add(new DateEntity(i.toString(), weekDay, false));
            }
        }
        this.actionListener = actionListener;
    }

    public int getTodayDate() {
        return todayDate;
    }

    public void setCurrentDate(int currentDate) {
        this.currentDate = currentDate;
    }

    public int getCurrentDate() {
        return currentDate;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setSelectedMonth(int selectedMonth) {
        this.selectedMonth = selectedMonth;
        updateDates();
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
        updateDates();
    }

    public DateActionListener getActionListener() {
        return actionListener;
    }

    public List<DateEntity> getDates() {
        return dates;
    }

    public void setDates(List<DateEntity> dates) {
        this.dates = dates;
        notifyDataSetChanged();
    }

    public void updateDates(){
        dates.clear();
        calendar.set(selectedYear, selectedMonth - 1, 1);
        int monthSize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(Integer i = 1; i <= monthSize; i++){
            calendar.set(selectedYear, selectedMonth - 1, i);
            String weekDay = new SimpleDateFormat("EE", russianLocale).format(calendar.getTime()).toUpperCase();
            if(selectedMonth == currentMonth && i == currentDate){
                DateEntity dateEntity = new DateEntity(i.toString(), weekDay, true);
                dates.add(dateEntity);
                actionListener.onDateSelected(dateEntity);
            }
            else {
                dates.add(new DateEntity(i.toString(), weekDay, false));
            }
        }
        notifyDataSetChanged();
    }

    public void setToCurrent(){
        calendar = Calendar.getInstance();
        selectedYear = currentYear = calendar.get(Calendar.YEAR);
        selectedMonth = currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentDate = todayDate;
        updateDates();
    }


    @Override
    public void onClick(View v) {
        DateEntity dateEntity = (DateEntity) v.getTag();
        actionListener.onDateSelected(dateEntity);
    }

    class DateViewHolder extends RecyclerView.ViewHolder {

        private ItemDateBinding binding;

        public DateViewHolder(@NonNull ItemDateBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDateBinding binding = ItemDateBinding.inflate(inflater, parent, false);

        binding.getRoot().setOnClickListener(this);

        return new DateViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        DateEntity date = dates.get(position);
        holder.itemView.setTag(date);
        holder.binding.weekDay.setText(date.getWeekDay());
        holder.binding.dateNumber.setText(date.getNumber());
        if(date.isSelected()){
            holder.binding.dateCard.setCardBackgroundColor(Color.WHITE);
            holder.binding.dateNumber.setTextColor(Color.parseColor("#4770FF"));
            holder.binding.weekDay.setTextColor(Color.parseColor("#4770FF"));
        }
        else{
            holder.binding.dateCard.setCardBackgroundColor(Color.parseColor("#4770FF"));
            holder.binding.dateNumber.setTextColor(Color.WHITE);
            holder.binding.weekDay.setTextColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }
}
