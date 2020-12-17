package com.example.lianxi3.adapter;

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
import com.example.lianxi3.R;
import com.example.lianxi3.bean.PicInfo;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class PicAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PicInfo.DataBeanX.DataBean> list;

    public PicAdapter(Context context, ArrayList<PicInfo.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_img_list, parent, false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PicInfo.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.name.setText(dataBean.getAuthor().getName());
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.iv);
        Object feeds_text = dataBean.getFeeds_text();
        if (feeds_text!=null){
            holder1.tv_xx.setText(feeds_text.toString());
        }else {
            holder1.tv_xx.setText("");
        }
        Glide.with(context).load(dataBean.getCover()).into(holder1.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView name;
        public TextView tv_xx;
        public ImageView img;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.tv_xx = (TextView) rootView.findViewById(R.id.tv_xx);
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }
}
