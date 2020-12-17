package com.example.day03_test01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_test01.R;
import com.example.day03_test01.bean.VideoBean;

import java.util.ArrayList;

public class VideoRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<VideoBean.DataBeanX.DataBean> list;

    public VideoRcyAdapter(Context context, ArrayList<VideoBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_image_item_video;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_image_item_video = (ImageView) rootView.findViewById(R.id.iv_image_item_video);
        }

    }
}
