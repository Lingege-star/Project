package com.example.day12_17.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day12_17.Bean.PicBean;
import com.example.day12_17.R;

import java.util.ArrayList;
import java.util.List;

public class RecAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<PicBean.DataBeanX.DataBean> pic;
    private int position1;


    public RecAdapter(Context context, ArrayList<PicBean.DataBeanX.DataBean> pic) {
        this.context = context;
        this.pic = pic;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new List_pic(LayoutInflater.from(context).inflate(R.layout.item_pic, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List_pic list = (List_pic) holder;


        Glide.with(context).load(pic.get(position).getAuthor()).into(list.imageHeader);
        list.tvUsername.setText(pic.get(position).getAuthor().getName());

        list.tvTitle.setText(pic.get(position).getFeeds_text());
        Glide.with(context).load(pic.get(position).getCover());

        list.tvLike.setText(pic.get(position).getUgc().getLikeCount()+"万");
        list.tvDis.setText("踩");
        list.tvCom.setText(pic.get(position).getUgc().getCommentCount());
        list.tvShare.setText(pic.get(position).getUgc().getShareCount());

    }

    @Override
    public int getItemCount() {
        return pic.size();
    }

    public void AddList(ArrayList<PicBean.DataBeanX.DataBean> picBean){
        pic.add(picBean.get(position1));
        notifyDataSetChanged();
    }


    class List_pic extends RecyclerView.ViewHolder {
        private ImageView imageHeader;
        private TextView tvUsername;
        private TextView tvTitle;
        private ImageView ivPic;
        private ImageView vpLike;
        private TextView tvLike;
        private ImageView vpDis;
        private TextView tvDis;
        private ImageView vpCom;
        private TextView tvCom;
        private ImageView vpShare;
        private TextView tvShare;
        public List_pic(@NonNull View itemView) {
            super(itemView);
            imageHeader = (ImageView) itemView.findViewById(R.id.image_header);
            tvUsername = (TextView) itemView.findViewById(R.id.tv_username);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            vpLike = (ImageView) itemView.findViewById(R.id.vp_like);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like);
            vpDis = (ImageView) itemView.findViewById(R.id.vp_dis);
            tvDis = (TextView) itemView.findViewById(R.id.tv_dis);
            vpCom = (ImageView) itemView.findViewById(R.id.vp_com);
            tvCom = (TextView) itemView.findViewById(R.id.tv_com);
            vpShare = (ImageView) itemView.findViewById(R.id.vp_share);
            tvShare = (TextView)itemView. findViewById(R.id.tv_share);
        }
    }
}
