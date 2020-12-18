package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bean.HotInfo;
import com.example.lianxi4.R;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.adapter
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public class HotAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HotInfo.DataBean> list;

    public HotAdapter(Context context, ArrayList<HotInfo.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotInfo.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(dataBean.getTitle().trim());
        holder1.tv.setText(dataBean.getLocation());
        holder1.time.setText(dataBean.getStartTime());
        Glide.with(context).load(dataBean.getCover()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView title;
        public TextView tv;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
}
