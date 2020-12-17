package com.example.lianxi3.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lianxi3.R;
import com.example.lianxi3.bean.VideoInfo;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.adapter
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class VideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<VideoInfo.DataBeanX.DataBean> list;

    public VideoAdapter(Context context, ArrayList<VideoInfo.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_main_list, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoInfo.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.name.setText(dataBean.getAuthor().getName());
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.iv);
        holder1.tv_xx.setText((String) dataBean.getFeeds_text());
        holder1.video.setVideoURI(Uri.parse(dataBean.getUrl()));
        holder1.video.start();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends PicAdapter.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView name;
        public TextView tv_xx;
        public VideoView video;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.tv_xx = (TextView) rootView.findViewById(R.id.tv_xx);
            this.video = (VideoView) rootView.findViewById(R.id.video);
        }

    }
}
