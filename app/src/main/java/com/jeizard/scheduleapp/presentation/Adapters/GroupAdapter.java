package com.jeizard.scheduleapp.presentation.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeizard.scheduleapp.R;
import com.jeizard.scheduleapp.databinding.ItemGroupBinding;
import com.jeizard.scheduleapp.domain.model.entities.GroupWithFullInformation;
import com.jeizard.scheduleapp.presentation.ActionListeners.GroupActionListener;

import java.util.Collections;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> implements View.OnClickListener {
    private GroupActionListener actionListener;

    public GroupAdapter(GroupActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public GroupAdapter() {
    }

    private List<GroupWithFullInformation> groupWithSpecialityAndFacultyList = Collections.emptyList();

    public void setGroupWithSpecialityAndFacultyList(List<GroupWithFullInformation> groupWithSpecialityAndFacultyList) {
        this.groupWithSpecialityAndFacultyList = groupWithSpecialityAndFacultyList;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        GroupWithFullInformation groupWithSpeciality = (GroupWithFullInformation) v.getTag();
        actionListener.onGroupAdd(groupWithSpeciality);
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {

        private ItemGroupBinding binding;

        public GroupViewHolder(@NonNull ItemGroupBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGroupBinding binding = ItemGroupBinding.inflate(inflater, parent, false);

        binding.getRoot().setOnClickListener(this);

        return new GroupViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        GroupWithFullInformation groupWithFullInformation = groupWithSpecialityAndFacultyList.get(position);
        holder.itemView.setTag(groupWithFullInformation);
        holder.binding.avatarImageView.setImageResource(R.drawable.ic_group_avatar);
        holder.binding.groupNumberTextView.setText(groupWithFullInformation.getNumber());
        holder.binding.groupCourseTextView.setText("Курс: ");
        holder.binding.groupCourseNumberTextView.setText(groupWithFullInformation.getStudyYearNumber());
        holder.binding.groupCourseFormTextView.setText(" (" + groupWithFullInformation.getEducationFormTitle() + ")");
        holder.binding.groupFacultyTextView.setText(groupWithFullInformation.getFacultyAbbreviation());
        holder.binding.hyphenTextView.setText(" - ");
        holder.binding.groupSpecialityTextView.setText(groupWithFullInformation.getSpecialityAbbreviation());
    }

    @Override
    public int getItemCount() {
        return groupWithSpecialityAndFacultyList.size();
    }


}
