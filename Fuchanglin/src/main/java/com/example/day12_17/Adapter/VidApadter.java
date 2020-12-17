package com.example.day12_17.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day12_17.Bean.VideoBean;
import com.example.day12_17.R;

import java.util.ArrayList;
import java.util.List;

public class VidApadter extends RecyclerView.Adapter {

    private final Context context;
    private final ArrayList<VideoBean.DataBeanX.DataBean> videoBeans;


    public VidApadter(Context context, ArrayList<VideoBean.DataBeanX.DataBean> videoBeans) {

        this.context = context;
        this.videoBeans = videoBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new List_video(LayoutInflater.from(context).inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List_video list = (List_video) holder;
        Glide.with(context).load(videoBeans.get(position).getAuthor()).into(list.imageHeader);

        Glide.with(context).load(videoBeans.get(position).getCover());
        String url = videoBeans.get(position).getUrl();
//        list.video.setVideoURI(url);


        list.tvLike.setText(videoBeans.get(position).getUgc().getLikeCount()+"万");
        list.tvDis.setText("踩");
        list.tvCom.setText(videoBeans.get(position).getUgc().getCommentCount());
        list.tvShare.setText(videoBeans.get(position).getUgc().getShareCount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private void initView() {

    }

    class List_video extends RecyclerView.ViewHolder {
        private ImageView imageHeader;
        private TextView tvUsername;
        private VideoView video;
        private ImageView vpLike;
        private TextView tvLike;
        private ImageView vpDis;
        private TextView tvDis;
        private ImageView vpCom;
        private TextView tvCom;
        private ImageView vpShare;
        private TextView tvShare;
        public List_video(@NonNull View itemView) {
            super(itemView);
            imageHeader = (ImageView) itemView.findViewById(R.id.image_header);
            tvUsername = (TextView) itemView.findViewById(R.id.tv_username);
            video = (VideoView) itemView.findViewById(R.id.video);
            vpLike = (ImageView) itemView.findViewById(R.id.vp_like);
            tvLike = (TextView) itemView.findViewById(R.id.tv_like);
            vpDis = (ImageView) itemView.findViewById(R.id.vp_dis);
            tvDis = (TextView) itemView.findViewById(R.id.tv_dis);
            vpCom = (ImageView) itemView.findViewById(R.id.vp_com);
            tvCom = (TextView) itemView.findViewById(R.id.tv_com);
            vpShare = (ImageView) itemView.findViewById(R.id.vp_share);
            tvShare = (TextView) itemView.findViewById(R.id.tv_share);
        }
    }
}
