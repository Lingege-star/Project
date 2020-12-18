package com.example.fuchanglin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.R;


import java.util.ArrayList;
import java.util.List;

public class HotspotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<News_1.DataBean.ListBean> list = new ArrayList<>();

    public HotspotAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<News_1.DataBean.ListBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constants.VIEW_TYPE_ZIEO) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.hotspot_one, parent, false);
            return new ViewHolderOne(inflate);
        } else if (viewType == Constants.VIEW_TYPE_ONE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.hotspot_two, parent, false);
            return new ViewHolderTwo(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.hotspot_three, parent, false);
            return new ViewHolderThree(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        News_1.DataBean.ListBean listBean = list.get(position);
        if (itemViewType == Constants.VIEW_TYPE_ZIEO){

            ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
            viewHolderOne.hotspot_title.setText(listBean.getTitle());
            viewHolderOne.hotspot_time.setText(listBean.getCreateTime());
            Glide.with(context).load(listBean.getFilePathList().get(0).getFilePath()).into(viewHolderOne.image1);
            Glide.with(context).load(listBean.getFilePathList().get(1).getFilePath()).into(viewHolderOne.image2);
            Glide.with(context).load(listBean.getFilePathList().get(2).getFilePath()).into(viewHolderOne.image3);

        }else if (itemViewType == Constants.VIEW_TYPE_ONE){

            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) holder;
            viewHolderTwo.hotspot_title.setText(listBean.getTitle());
            viewHolderTwo.hotspot_time.setText(listBean.getCreateTime());
            Glide.with(context).load(listBean.getFilePathList().get(0).getFilePath()).into(viewHolderTwo.hotspot_img);

        }else {

            ViewHolderThree viewHolderThree = (ViewHolderThree) holder;
            viewHolderThree.hotspot_title.setText(listBean.getTitle());
            viewHolderThree.hotspot_time.setText(listBean.getCreateTime());

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return Constants.VIEW_TYPE_ZIEO;
        } else if (position % 3 == 1) {
            return Constants.VIEW_TYPE_ONE;
        } else {
            return Constants.VIEW_TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView hotspot_title;
        public ImageView image1;
        public ImageView image2;
        public ImageView image3;
        public TextView hotspot_time;

        public ViewHolderOne(View rootView) {
            super(rootView);
            this.hotspot_title = (TextView) rootView.findViewById(R.id.hotspot_title);
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
            this.image2 = (ImageView) rootView.findViewById(R.id.image2);
            this.image3 = (ImageView) rootView.findViewById(R.id.image3);
            this.hotspot_time = (TextView) rootView.findViewById(R.id.hotspot_time);
        }

    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView hotspot_title;
        public TextView hotspot_time;
        public ImageView hotspot_img;

        public ViewHolderTwo(View rootView) {
            super(rootView);
            this.hotspot_title = (TextView) rootView.findViewById(R.id.hotspot_title);
            this.hotspot_time = (TextView) rootView.findViewById(R.id.hotspot_time);
            this.hotspot_img = (ImageView) rootView.findViewById(R.id.hotspot_img);
        }

    }

    class ViewHolderThree extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView hotspot_title;
        public TextView hotspot_time;

        public ViewHolderThree(View rootView) {
            super(rootView);
            this.hotspot_title = (TextView) rootView.findViewById(R.id.hotspot_title);
            this.hotspot_time = (TextView) rootView.findViewById(R.id.hotspot_time);
        }

    }
}
