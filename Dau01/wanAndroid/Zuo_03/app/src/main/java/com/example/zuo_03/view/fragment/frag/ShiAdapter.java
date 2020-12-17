package com.example.zuo_03.view.fragment.frag;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zuo_03.R;
import com.example.zuo_03.modle.bean.ShiBean;

import java.util.ArrayList;
import java.util.HashMap;

import cn.jzvd.JzvdStd;

class ShiAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShiBean.DataBeanX.DataBean.AuthorBean> beans;
    private ArrayList<ShiBean.DataBeanX.DataBean> list;

    public ShiAdapter(Context context, ArrayList<ShiBean.DataBeanX.DataBean.AuthorBean> beans, ArrayList<ShiBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.beans = beans;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ShiBean.DataBeanX.DataBean dataBean = list.get(position);
        ShiBean.DataBeanX.DataBean.AuthorBean authorBean = beans.get(position);
        viewHolder.jz.setUp(dataBean.getUrl(),"文艺青年");

        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(dataBean.getUrl(),new HashMap<String, String>());
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(7000 * 1000, MediaMetadataRetriever.OPTION_CLOSEST);
        viewHolder.jz.posterImageView.setImageBitmap(frameAtTime);
        viewHolder.jz.startVideo();

        viewHolder.name.setText(authorBean.getName());
        Glide.with(context).load(authorBean.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv);
        viewHolder.title.setText(dataBean.getFeeds_text()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView name;
        public TextView title;
        public JzvdStd jz;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.jz = (JzvdStd) rootView.findViewById(R.id.jz);
        }

    }
}
