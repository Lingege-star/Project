package com.example.day03_test01.adapter;

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
import com.example.day03_test01.R;
import com.example.day03_test01.bean.PicBean;

import java.util.ArrayList;
import java.util.List;

public class PicRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<PicBean.DataBeanX.DataBean> list;

    public PicRcyAdapter(Context context, ArrayList<PicBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder itemHolder = (ViewHolder) holder;
        PicBean.DataBeanX.DataBean dataBean = list.get(position);
        itemHolder.tv_intro_item_pic.setText(dataBean.getIntro());
        itemHolder.tv_title_item_pic.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getActivityIcon())
                .apply(new RequestOptions().placeholder(R.drawable.black_background))
                .into(itemHolder.iv_icon_item_pic);
        Glide.with(context).load(dataBean.getBackground())
                .apply(new RequestOptions().placeholder(R.drawable.black_background))
                .into(itemHolder.iv_image_item_pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void addPic(List<PicBean.DataBeanX.DataBean> data) {
        if (data!=null&&data.size()>0){
            list.addAll(data);
            notifyDataSetChanged();
        }
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_intro_item_pic;
        public ImageView iv_image_item_pic;
        public ImageView iv_icon_item_pic;
        public TextView tv_title_item_pic;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_intro_item_pic = (TextView) rootView.findViewById(R.id.tv_intro_item_pic);
            this.iv_image_item_pic = (ImageView) rootView.findViewById(R.id.iv_image_item_pic);
            this.iv_icon_item_pic = (ImageView) rootView.findViewById(R.id.iv_icon_item_pic);
            this.tv_title_item_pic = (TextView) rootView.findViewById(R.id.tv_title_item_pic);
        }

    }
}
