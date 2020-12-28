package com.example.jpush_test.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jpush_test.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;
    private ArrayList<Integer> ban;

    public MainAdapter(Context context, ArrayList<View> list, ArrayList<Integer> ban) {
        this.context = context;
        this.list = list;
        this.ban = ban;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item1, null);
            return new ViewHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
            return new ViewHolder2(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item3, null);
            return new ViewHolder3(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item4, null);
            return new ViewHolder4(view);
        } else if (viewType == 4) {
            View view = LayoutInflater.from(context).inflate(R.layout.item5, null);
            return new ViewHolder5(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.toolbar.setTitle("首页");
            ban = new ArrayList<>();
            ban.add(R.drawable.a2);
            ban.add(R.drawable.a3);
            ban.add(R.drawable.a4);
            ban.add(R.drawable.a7);
            holder1.ban_main.setImages(ban).setImageLoader(new ImageLoader() {
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
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Toolbar toolbar;
        public Banner ban_main;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
            this.ban_main = (Banner) rootView.findViewById(R.id.ban_main);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_1;
        public Button btn_1;
        public Button btn_2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.btn_1 = (Button) rootView.findViewById(R.id.btn_1);
            this.btn_2 = (Button) rootView.findViewById(R.id.btn_2);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
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

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_1;
        public TextView tv_2;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
        }

    }

    public static
    class ViewHolder5 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_1;
        public TextView tv_2;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
        }

    }
}
