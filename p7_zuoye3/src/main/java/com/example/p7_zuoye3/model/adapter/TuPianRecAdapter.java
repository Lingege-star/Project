package com.example.p7_zuoye3.model.adapter;

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
import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.model.bean.TuPianBean;

import java.util.ArrayList;

public class TuPianRecAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<TuPianBean.DataBeanX.DataBean> list;

    public TuPianRecAdapter(Context context, ArrayList<TuPianBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_tu_rec, null);
            return new ViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_tu_rec2, null);
            return new ViewHolder2(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==0){
            TuPianBean.DataBeanX.DataBean dataBean = list.get(position);
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.tv_text.setText(dataBean.getFeeds_text());
            holder1.tv_activitytext.setText(dataBean.getActivityText());
            Glide.with(context).load(dataBean.getCover()).into(holder1.iv_cover);
        }else {
            TuPianBean.DataBeanX.DataBean dataBean = list.get(position);
            TuPianBean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
            ViewHolder2 holder1 = (ViewHolder2) holder;
            holder1.tv_name.setText(author.getName());
            Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.iv_avatar);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public ImageView iv_cover;
        public TextView tv_activitytext;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.tv_activitytext = (TextView) rootView.findViewById(R.id.tv_activitytext);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_avatar;
        public TextView tv_name;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_avatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
