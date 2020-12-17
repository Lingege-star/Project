package com.example.lianxi3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lianxi3.R;
import com.example.lianxi3.bean.LikeInfo;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.adapter
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class LikeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<LikeInfo.DataBeanX.DataBean> list;

    public LikeAdapter(Context context, ArrayList<LikeInfo.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_rcy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LikeInfo.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.item_title.setText(dataBean.getTitle());
        holder1.item_desc.setText(dataBean.getFeedNum()+"条热门内容");
        Glide.with(context).load(dataBean.getIcon()).into(holder1.item_iv);
        holder1.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder1.tv.setText("已关注");
                holder1.tv.setTextColor(Color.BLACK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView item_iv;
        public TextView item_title;
        public TextView item_desc;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.item_iv = (ImageView) rootView.findViewById(R.id.item_iv);
            this.item_title = (TextView) rootView.findViewById(R.id.item_title);
            this.item_desc = (TextView) rootView.findViewById(R.id.item_desc);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
