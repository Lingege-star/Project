package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.myapplication.R;
import com.example.myapplication.bean.CourseSubBean;

import java.util.ArrayList;
import java.util.List;

public class SelCourseSubAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<CourseSubBean.DataBean> dataBeans;
    private final Context context;
    private final LayoutInflater inflater;

    public SelCourseSubAdapter(List<CourseSubBean.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelCourseSubViewHolder(inflater.inflate(R.layout.sel_course_sub_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SelCourseSubViewHolder holder1 = (SelCourseSubViewHolder) holder;
        holder1.checkBox.setText(dataBeans.get(position).getShort_name());
        holder1.checkBox.setChecked(dataBeans.get(position).isChecked());


        holder1.checkBox.setOnClickListener(v -> {
            subItemClick.onSubItemClick(position);
        });
    }

    public interface SelCourseSubItemClick{
        void onSubItemClick(int position);
    }

    public SelCourseSubItemClick subItemClick;

    public void setSubItemClick(SelCourseSubItemClick subItemClick) {
        this.subItemClick = subItemClick;
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class SelCourseSubViewHolder extends ViewHolder {
        CheckBox checkBox;
        public SelCourseSubViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.sel_course_sub_item_cb);
        }
    }
}
