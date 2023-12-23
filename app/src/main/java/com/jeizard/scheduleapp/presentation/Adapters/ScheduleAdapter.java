package com.jeizard.scheduleapp.presentation.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.jeizard.scheduleapp.R;
import com.jeizard.scheduleapp.databinding.ItemGroupBinding;
import com.jeizard.scheduleapp.databinding.ItemTrackableScheduleBinding;
import com.jeizard.scheduleapp.domain.model.entities.Group;
import com.jeizard.scheduleapp.domain.model.entities.LessonWithFullInformation;
import com.jeizard.scheduleapp.presentation.ActionListeners.ScheduleActionListener;
import com.jeizard.scheduleapp.presentation.ViewModels.DailyScheduleViewModel;
import com.jeizard.scheduleapp.presentation.ViewModels.Factories.DailyScheduleViewModelFactory;

import java.util.Collections;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> implements View.OnClickListener {
    private ScheduleActionListener actionListener;
    private Activity activity;

    private int position;
    public int getContextMenuPosition() { return position; }
    public void setContextMenuPosition(int position) { this.position = position; }
    public Group selectedGroupContex;

    private Group selectedGroup;
    private int selectedGroupIndex;


    public ScheduleAdapter(ScheduleActionListener actionListener, Activity activity) {
        this.actionListener = actionListener;
        this.activity = activity;
    }

    public ScheduleAdapter() {
    }

    public Group getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Group selectedGroup) {
        this.selectedGroup = selectedGroup;
        selectedGroupIndex = groups.indexOf(selectedGroup);
    }

    public int getSelectedGroupIndex() {
        return selectedGroupIndex;
    }

    private List<Group> groups = Collections.emptyList();

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        notifyDataSetChanged();
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public void onClick(View v) {
        Group group = (Group) v.getTag();
        actionListener.onGroupSelected(group);
    }

    class ScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private ItemTrackableScheduleBinding binding;

        public ScheduleViewHolder(@NonNull ItemTrackableScheduleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            selectedGroupContex = groups.get(getContextMenuPosition());
            DailyScheduleViewModel dailyScheduleViewModel = new ViewModelProvider((ViewModelStoreOwner) activity,
                    new DailyScheduleViewModelFactory(activity, activity.getApplication()))
                    .get(DailyScheduleViewModel.class);
            if(dailyScheduleViewModel.getCurrentUserRole() != null) {
                if (dailyScheduleViewModel.getCurrentUserRole().equals("admin")) {
                    menu.add(Menu.NONE, 5, Menu.NONE, "Добавить в список предзагруженных");
                }
            }
            menu.add(Menu.NONE, 3, Menu.NONE, "Обновить");
            menu.add(Menu.NONE, 4, Menu.NONE, "Удалить");
        }
    }
    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTrackableScheduleBinding binding = ItemTrackableScheduleBinding.inflate(inflater, parent, false);

        binding.getRoot().setOnClickListener(this);

        return new ScheduleViewHolder(binding);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Group group = groups.get(position);
        holder.itemView.setTag(group);
        holder.binding.avatarImageView.setImageResource(R.drawable.ic_schedule_avatar);
        holder.binding.scheduleName.setText("Группа: " + group.getNumber());
        if(group.getNumber().equals(selectedGroup.getNumber())){
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#A2A2A2"));
        }
        else{
            holder.binding.cardView.setCardBackgroundColor(Color.parseColor("#DDDDDD"));
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
    public void onViewRecycled(@NonNull ScheduleViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }
}
