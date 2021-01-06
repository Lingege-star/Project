package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.myapplication.R;
import com.example.myapplication.bean.CourseSubBean;

import java.util.List;

public class SelCourseAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<List<CourseSubBean.DataBean>> dataBeans;
    private final Context context;
    private final LayoutInflater inflater;
    private SelCourseSubAdapter mAdapter;

    public SelCourseAdapter(List<List<CourseSubBean.DataBean>> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelCourseViewHolder(inflater.inflate(R.layout.sel_course_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SelCourseViewHolder holder1 = (SelCourseViewHolder) holder;
        holder1.school_name.setText(dataBeans.get(position).get(0).getSchool_name());
        holder1.sel_course_rec.setLayoutManager(new GridLayoutManager(context, 3));
        mAdapter = new SelCourseSubAdapter(dataBeans.get(position), context);
        holder1.sel_course_rec.setAdapter(mAdapter);


        mAdapter.setSubItemClick(pos -> {
            for (int i = 0; i < dataBeans.size(); i++) {
                for (int j = 0; j < dataBeans.get(i).size(); j++) {
                    if (i == position && pos == j)
                        dataBeans.get(i).get(j).setChecked(true);
                    else
                        dataBeans.get(i).get(j).setChecked(false);
                }
            }
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class SelCourseViewHolder extends ViewHolder {
        TextView school_name;
        RecyclerView sel_course_rec;

        public SelCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            school_name = itemView.findViewById(R.id.sel_course_item_school_name);
            sel_course_rec = itemView.findViewById(R.id.sel_course_item_rec);
        }
    }
}
