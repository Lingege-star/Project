package com.example.a1217lian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.a1217lian.R;
import com.example.a1217lian.bean.PicBean;

import java.util.ArrayList;
import java.util.logging.Handler;

public class PicRecyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PicBean.DataBeanX.DataBean> list;

    public PicRecyAdapter(Context context, ArrayList<PicBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_picrecy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_head);
        viewHolder.tv_head.setText(list.get(position).getAuthor().getName());
        Glide.with(context).load(list.get(position).getCover()).into(viewHolder.iv_text);
        viewHolder.tv_text.setText(list.get(position).getFeeds_text());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_head;
        public TextView tv_head;
        public TextView tv_text;
        public ImageView iv_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.tv_head = (TextView) rootView.findViewById(R.id.tv_head);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.iv_text = (ImageView) rootView.findViewById(R.id.iv_text);
        }

    }
}
