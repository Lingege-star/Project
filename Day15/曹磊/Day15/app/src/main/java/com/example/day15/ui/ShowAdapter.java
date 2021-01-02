package com.example.day15.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day15.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class ShowAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;

    public ShowAdapter(Context context, ArrayList<View> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new ViewHolder1(view1);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type==0){
            ViewHolder1 holder1= (ViewHolder1) holder;
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(R.drawable.c1);
            integers.add(R.drawable.c2);
            integers.add(R.drawable.c3);
            integers.add(R.drawable.c4);

            holder1.banner.setImages(integers).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
        }

    }
}
