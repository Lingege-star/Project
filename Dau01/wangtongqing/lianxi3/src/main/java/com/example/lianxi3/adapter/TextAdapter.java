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
import com.example.lianxi3.bean.TextInfo;

import java.util.ArrayList;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.adapter
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class TextAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TextInfo.DataBeanX.DataBean> list;

    public TextAdapter(Context context, ArrayList<TextInfo.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_text_list, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextInfo.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.iv);
        holder1.name.setText(dataBean.getAuthor().getName());
        Object text = dataBean.getActivityText();
        if (text!=null){
            holder1.tv_xx.setText(text.toString());
            holder1.tv.setVisibility(View.GONE);
        }else {
            holder1.tv_xx.setVisibility(View.GONE);
        }
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
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.tv_xx = (TextView) rootView.findViewById(R.id.tv_xx);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
