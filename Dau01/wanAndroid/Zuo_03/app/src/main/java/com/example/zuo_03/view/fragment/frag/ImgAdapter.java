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
import com.example.zuo_03.modle.bean.ImageBean;

import java.util.ArrayList;

class ImgAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ImageBean.DataBeanX.DataBean.AuthorBean> list;
    private ArrayList<ImageBean.DataBeanX.DataBean> image;
    private ImageView iv;
    private TextView name;
    private TextView title;
    private ImageView img;

    public ImgAdapter(Context context, ArrayList<ImageBean.DataBeanX.DataBean.AuthorBean> list, ArrayList<ImageBean.DataBeanX.DataBean> image) {
        this.context = context;
        this.list = list;
        this.image = image;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_img, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageBean.DataBeanX.DataBean.AuthorBean authorBean = list.get(position);
        ImageBean.DataBeanX.DataBean dataBean = image.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(authorBean.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv);
        viewHolder.name.setText(authorBean.getName());
        viewHolder.title.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.img);
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
        public ImageView img;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }
}
