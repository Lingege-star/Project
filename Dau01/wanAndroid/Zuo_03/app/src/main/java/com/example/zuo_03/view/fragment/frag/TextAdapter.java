package com.example.zuo_03.view.fragment.frag;

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
import com.example.zuo_03.R;
import com.example.zuo_03.modle.bean.TextBean;

import java.util.ArrayList;

class TextAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TextBean.DataBeanX.DataBean.AuthorBean> list;
    private ArrayList<TextBean.DataBeanX.DataBean> beans;

    public TextAdapter(Context context, ArrayList<TextBean.DataBeanX.DataBean.AuthorBean> list, ArrayList<TextBean.DataBeanX.DataBean> beans) {
        this.context = context;
        this.list = list;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        TextBean.DataBeanX.DataBean.AuthorBean authorBean = list.get(position);
        TextBean.DataBeanX.DataBean dataBean = beans.get(position);
        Glide.with(context).load(authorBean.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv);
        viewHolder.name.setText(authorBean.getName());
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

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
