package com.example.day15.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.App;
import com.example.day15.map.model.RxOpretorlmpl;
import com.example.day15.map.model.bean.XuanBean;

import java.util.ArrayList;
import java.util.List;

public class SelCourseAdapter extends RecyclerView.Adapter {
    private List<List<XuanBean.DataBean>> mdata;
    private RxOpretorlmpl impl=new RxOpretorlmpl();

    public SelCourseAdapter(List<List<XuanBean.DataBean>> data) {
        this.mdata=data;
        impl=new RxOpretorlmpl();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.context()).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        String school_name = mdata.get(position).get(0).getSchool_name();
        holder1.tv.setText(school_name);
        List<XuanBean.DataBean> beans = mdata.get(position);
        holder1.rlv.setLayoutManager(new GridLayoutManager(App.context(),3));
        XuanAdapter xuanAdapter = new XuanAdapter(beans);
        holder1.rlv.setAdapter(xuanAdapter);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static
    class ViewHolder extends RlvAdapter.ViewHolder {
        public View rootView;
        public RecyclerView rlv;
        public TextView tv;
        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rlv = (RecyclerView) rootView.findViewById(R.id.rlv);
            this.tv=(TextView) rootView.findViewById(R.id.tv);
        }

    }
}
