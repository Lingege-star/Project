package com.example.day15.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.App;
import com.example.day15.map.model.bean.XuanBean;

import java.util.List;

public class XuanAdapter extends RecyclerView.Adapter {
    private List<XuanBean.DataBean> beanList;

    public XuanAdapter(List<XuanBean.DataBean> beans) {
        this.beanList = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.context()).inflate(R.layout.item_rent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        String short_name = beanList.get(position).getShort_name();
        ((ViewHolder) holder).box_ok.setText(short_name);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public static
    class ViewHolder extends RlvAdapter.ViewHolder {
        public View rootView;
        public CheckBox box_ok;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.box_ok = (CheckBox) rootView.findViewById(R.id.box_ok);
        }

    }
}
