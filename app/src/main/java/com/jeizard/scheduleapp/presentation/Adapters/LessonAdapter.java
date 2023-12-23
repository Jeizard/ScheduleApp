package com.jeizard.scheduleapp.presentation.Adapters;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeizard.scheduleapp.databinding.ItemLessonBinding;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.presentation.ActionListeners.LessonActionListener;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> implements View.OnClickListener {
    private LessonActionListener actionListener;

    private int position;
    public int getContextMenuPosition() { return position; }
    public void setContextMenuPosition(int position) { this.position = position; }
    public LessonWithFullInformation selectedLesson;


    public LessonAdapter(LessonActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public LessonAdapter() {
    }

    private List<LessonWithFullInformation> lessonList = Collections.emptyList();

    public void setLessonList(List<LessonWithFullInformation> lessonList) {
        this.lessonList = lessonList;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        LessonWithFullInformation lesson = (LessonWithFullInformation) v.getTag();
        actionListener.onLessonSelected(lesson);
    }



    class LessonViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private ItemLessonBinding binding;

        public LessonViewHolder(@NonNull ItemLessonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            selectedLesson = lessonList.get(getContextMenuPosition());
            menu.add(Menu.NONE, 1, Menu.NONE, "Редактировать");
            menu.add(Menu.NONE, 2, Menu.NONE, "Удалить");
        }
    }
    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemLessonBinding binding = ItemLessonBinding.inflate(inflater, parent, false);

        binding.getRoot().setOnClickListener(this);

        return new LessonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        LessonWithFullInformation lesson = lessonList.get(position);
        holder.itemView.setTag(lesson);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        holder.binding.startTime.setText(dateFormat.format(lesson.getStartTime()));
        holder.binding.endTime.setText(dateFormat.format(lesson.getEndTime()));
        holder.binding.lessonType.setText(lesson.getTypeAbbreviation());
        holder.binding.lessonSubject.setText(lesson.getSubjectAbbreviation());
        holder.binding.lessonCabinet.setText(lesson.getCabinetNumber() + " к.");
        String teacherSurname = lesson.getTeacherSurname();
        String teacherName = lesson.getTeacherName();
        String teacherPatronymic = lesson.getTeacherPatronymic();

        if (teacherSurname != null && teacherName != null && teacherPatronymic != null
                && !teacherName.isEmpty() && !teacherPatronymic.isEmpty()) {
            String abbreviatedName = teacherSurname + " " + teacherName.charAt(0) + "." + teacherPatronymic.charAt(0) + ".";
            holder.binding.lessonTeacher.setText(abbreviatedName);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setContextMenuPosition(holder.getLayoutPosition());
                return false;
            }
        });
    }

    @Override
    public void onViewRecycled(@NonNull LessonViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }
}
