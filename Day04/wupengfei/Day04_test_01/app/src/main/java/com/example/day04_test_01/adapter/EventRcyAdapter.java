package com.example.day04_test_01.adapter;

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
import com.example.day04_test_01.R;
import com.example.day04_test_01.bean.EventsBean;

import java.util.ArrayList;
import java.util.List;

public class EventRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<EventsBean.DataBean> list;

    public EventRcyAdapter(Context context, ArrayList<EventsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        EventsBean.DataBean dataBean = list.get(position);
        itemHolder.tv_title_event.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getCover())
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(itemHolder.iv_image_item_event);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<EventsBean.DataBean> data) {
        if (data!=null&&data.size()>0){
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_image_item_event;
        public TextView tv_title_event;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_image_item_event = (ImageView) rootView.findViewById(R.id.iv_image_item_event);
            this.tv_title_event = (TextView) rootView.findViewById(R.id.tv_title_event);
        }

    }
}
