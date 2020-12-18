package com.example.p7_zuoye4;

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

import java.util.ArrayList;
import java.util.List;

public class HotRecAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<HotBean.DataBean.ListBean> list;

    public HotRecAdapter(Context context, ArrayList<HotBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position % 3 == 0) {
            return 0;
        } else if (position - 1 % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_zz_rec1, null);
            return new ZhuangZaoRecAdapter.ViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_zz_rec2, null);
            return new ZhuangZaoRecAdapter.ViewHolder2(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_zz_rec3, null);
            return new ZhuangZaoRecAdapter.ViewHolder3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==0){
            HotBean.DataBean.ListBean listBean = list.get(position);
            ZhuangZaoRecAdapter.ViewHolder holder1 = (ZhuangZaoRecAdapter.ViewHolder) holder;
            holder1.tv_1.setText(listBean.getTitle());
            holder1.tv_2.setText(listBean.getCreateTime());
            List<HotBean.DataBean.ListBean.FilePathListBean> filePathList = listBean.getFilePathList();
            for (int i = 0; i <filePathList.size() ; i++) {
                Glide.with(context).load(filePathList.get(0).getFilePath()).into(holder1.iv_image1);
                Glide.with(context).load(filePathList.get(1).getFilePath()).into(holder1.iv_image2);
                Glide.with(context).load(filePathList.get(2).getFilePath()).into(holder1.iv_image3);
            }
        }else if(type==1){
            HotBean.DataBean.ListBean listBean = list.get(position);
            ZhuangZaoRecAdapter.ViewHolder2 holder1 = (ZhuangZaoRecAdapter.ViewHolder2) holder;
            holder1.tv_1.setText(listBean.getTitle());
            holder1.tv_2.setText(listBean.getCreateTime());
            List<HotBean.DataBean.ListBean.FilePathListBean> filePathList = listBean.getFilePathList();
            for (int i = 0; i <filePathList.size() ; i++) {
                Glide.with(context).load(filePathList.get(0).getFilePath()).into(holder1.iv_image1);
            }
        }else {
            HotBean.DataBean.ListBean listBean = list.get(position);
            ZhuangZaoRecAdapter.ViewHolder3 holder1 = (ZhuangZaoRecAdapter.ViewHolder3) holder;
            holder1.tv_1.setText(listBean.getTitle());
            holder1.tv_2.setText(listBean.getCreateTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_1;
        public ImageView iv_image1;
        public ImageView iv_image2;
        public ImageView iv_image3;
        public LinearLayout ll;
        public TextView tv_2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.iv_image1 = (ImageView) rootView.findViewById(R.id.iv_image1);
            this.iv_image2 = (ImageView) rootView.findViewById(R.id.iv_image2);
            this.iv_image3 = (ImageView) rootView.findViewById(R.id.iv_image3);
            this.ll = (LinearLayout) rootView.findViewById(R.id.ll);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_1;
        public TextView tv_2;
        public ImageView iv_image1;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
            this.iv_image1 = (ImageView) rootView.findViewById(R.id.iv_image1);
        }

    }


    public static
    class ViewHolder3 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_1;
        public TextView tv_2;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
        }

    }
}
