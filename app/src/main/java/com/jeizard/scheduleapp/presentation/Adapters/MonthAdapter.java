package com.jeizard.scheduleapp.presentation.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeizard.scheduleapp.databinding.ItemMonthBinding;
import com.jeizard.scheduleapp.domain.model.entities.MonthEntity;
import com.jeizard.scheduleapp.presentation.ActionListeners.MonthActionListener;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MonthViewHolder> implements View.OnClickListener{

    private MonthActionListener actionListener;
    Calendar calendar = Calendar.getInstance();
    Locale russianLocale = new Locale("ru", "RU");
    int currentMonth = calendar.get(Calendar.MONTH) + 1;
    Integer currentYear = calendar.get(Calendar.YEAR);
    int selectedMonth = currentMonth;
    int selectedYear = currentYear;
    private List<MonthEntity> months = new ArrayList<>();
    int monthSize = 12;
    public MonthAdapter(MonthActionListener actionListener) {
        for(Integer i = 1; i <= monthSize; i++){
            String month =  new DateFormatSymbols(russianLocale).getMonths()[i - 1];
            if(i == currentMonth){
                MonthEntity monthEntity = new MonthEntity(i.toString(), month, currentYear.toString(), true);
                months.add(monthEntity);
                selectedMonth =  Integer.parseInt(monthEntity.getNumber());
            }
            else {
                months.add(new MonthEntity(i.toString(), month, currentYear.toString(), false));
            }
        }
        this.actionListener = actionListener;
    }

    public Integer getCurrentYear() {
        return currentYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(int selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public MonthActionListener getActionListener() {
        return actionListener;
    }

    public List<MonthEntity> getMonths() {
        return months;
    }

    public void setMonths(List<MonthEntity> months) {
        this.months = months;
        notifyDataSetChanged();
    }

    public void updateMonth(){
        months.clear();
        for(Integer i = 1; i <= monthSize; i++){
            String month =  new DateFormatSymbols(russianLocale).getMonths()[i - 1];
            if(i == currentMonth){
                MonthEntity monthEntity = new MonthEntity(i.toString(), month, currentYear.toString(), true);
                months.add(monthEntity);
                selectedMonth =  Integer.parseInt(monthEntity.getNumber());
                actionListener.onMonthSelected(monthEntity);
            }
            else {
                months.add(new MonthEntity(i.toString(), month, currentYear.toString(), false));
            }
        }
        notifyDataSetChanged();
    }

    public void setToCurrent(){
        calendar = Calendar.getInstance();
        selectedYear = currentYear;
        selectedMonth = currentMonth;
        updateMonth();
    }
    @Override
    public void onClick(View v) {
        MonthEntity monthEntity = (MonthEntity) v.getTag();
        actionListener.onMonthSelected(monthEntity);
    }

    class MonthViewHolder extends RecyclerView.ViewHolder {

        private ItemMonthBinding binding;

        public MonthViewHolder(@NonNull ItemMonthBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @NonNull
    @Override
    public MonthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemMonthBinding binding = ItemMonthBinding.inflate(inflater, parent, false);

        binding.getRoot().setOnClickListener(this);

        return new MonthViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthViewHolder holder, int position) {
        MonthEntity month = months.get(position);
        holder.itemView.setTag(month);
        holder.binding.month.setText(month.getMonth() + ", " + month.getYear());
        if(month.isSelected()){
            holder.binding.month.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else{
            holder.binding.month.setTextColor(Color.parseColor("#B2FFFFFF"));
        }
    }

    @Override
    public int getItemCount() {
        return months.size();
    }
}
