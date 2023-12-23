package com.jeizard.scheduleapp.presentation.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jeizard.scheduleapp.presentation.Enum.LessonTypesEnum;

public class LessonTypesAdapter extends ArrayAdapter<LessonTypesEnum> {
    public LessonTypesAdapter(Context context, int resource, LessonTypesEnum[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setText(getItem(position).getAbbreviation());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setText(getItem(position).getAbbreviation());
        return label;
    }
}
