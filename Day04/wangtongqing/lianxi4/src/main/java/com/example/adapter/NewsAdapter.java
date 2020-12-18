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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.bean.NewsInfo;
import com.example.lianxi4.R;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.adapter
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public class NewsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<NewsInfo.DataBean.ListBean> list;

    public NewsAdapter(Context context, ArrayList<NewsInfo.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private int one = 0;
    private int two = 1;
    private int three = 2;

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return one;
        } else if (position % 3 == 1) {
            return two;
        } else {
            return three;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == one) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_disone, parent, false);
            return new ViewHolderone(view);
        } else if (viewType == two) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_distwo, parent, false);
            return new ViewHoldertwo(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_dis, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsInfo.DataBean.ListBean listBean = list.get(position);
        if (getItemViewType(position) == one) {
            ViewHolderone holder1 = (ViewHolderone) holder;
            holder1.title.setText(listBean.getTitle());
            if (listBean.getFilePathList().size()>0) {
                Glide.with(context).load(listBean.getFilePathList().get(0).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(holder1.ivone);
                Glide.with(context).load(listBean.getFilePathList().get(1).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(holder1.ivtwo);
                Glide.with(context).load(listBean.getFilePathList().get(2).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(holder1.iv);
            }else {
                holder1.iv.setVisibility(View.GONE);
                holder1.ivone.setVisibility(View.GONE);
                holder1.ivtwo.setVisibility(View.GONE);
            }
            holder1.time.setText(listBean.getCreateTime());
        } else if (getItemViewType(position) == two) {
            ViewHoldertwo holder2 = (ViewHoldertwo) holder;
            holder2.title.setText(listBean.getTitle());
            if (listBean.getFilePathList().size()>0) {
                Glide.with(context).load(listBean.getFilePathList().get(0).getFilePath()).apply(RequestOptions.bitmapTransform(new RoundedCorners(30))).into(holder2.iv);
            }else {
                holder2.iv.setVisibility(View.GONE);
            }
            holder2.time.setText(listBean.getCreateTime());
        } else {
            ViewHolder holder3 = (ViewHolder) holder;
            holder3.title.setText(listBean.getTitle());
            holder3.time.setText(listBean.getCreateTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderone extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView ivone;
        public ImageView ivtwo;
        public ImageView iv;
        public TextView time;

        public ViewHolderone(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.ivone = (ImageView) rootView.findViewById(R.id.ivone);
            this.ivtwo = (ImageView) rootView.findViewById(R.id.ivtwo);
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }

    public static class ViewHoldertwo extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title;
        public ImageView iv;
        public TextView time;

        public ViewHoldertwo(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
}
