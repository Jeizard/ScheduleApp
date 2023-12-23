package com.jeizard.scheduleapp.presentation.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jeizard.scheduleapp.presentation.Enum.WeekDaysEnum;

public class WeekDaysAdapter extends ArrayAdapter<WeekDaysEnum> {
    public WeekDaysAdapter(Context context, int resource, WeekDaysEnum[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setText(getItem(position).getFullName());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setText(getItem(position).getFullName());
        return label;
    }
}
