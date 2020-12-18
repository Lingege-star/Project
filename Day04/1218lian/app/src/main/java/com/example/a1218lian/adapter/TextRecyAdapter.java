package com.example.a1218lian.adapter;

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
import com.example.a1218lian.R;
import com.example.a1218lian.bean.TextBean;


import java.util.ArrayList;

public class TextRecyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TextBean.DataBeanX.DataBean> list;

    public TextRecyAdapter(Context context, ArrayList<TextBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_textrecy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_head.setText(list.get(position).getAuthor().getName());
        viewHolder.tv_text.setText(list.get(position).getFeeds_text()+"");
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_head);
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

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.tv_head = (TextView) rootView.findViewById(R.id.tv_head);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
        }

    }
}
