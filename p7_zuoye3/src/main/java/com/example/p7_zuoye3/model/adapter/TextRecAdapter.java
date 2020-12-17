package com.example.p7_zuoye3.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.model.bean.TextBean;

import java.util.ArrayList;

public class TextRecAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<TextBean.DataBeanX.DataBean> list;

    public TextRecAdapter(Context context, ArrayList<TextBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_text, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextBean.DataBeanX.DataBean dataBean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        TextBean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
        Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop()).into(holder1.iv_avatar);
        holder1.tv_name.setText(author.getName());
        holder1.tv_text.setText(author.getQqOpenId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_avatar;
        public TextView tv_name;
        public TextView tv_text;
        public LinearLayout ll;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_avatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.ll = (LinearLayout) rootView.findViewById(R.id.ll);
        }

    }
}
