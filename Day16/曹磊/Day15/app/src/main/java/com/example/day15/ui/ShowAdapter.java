package com.example.day15.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day15.R;
import com.example.day15.ui.iv_activity.IvActivity;
import com.example.day15.ui.tab_activity.AnsweringActivity;
import com.example.day15.ui.tab_activity.CourseActivity;
import com.example.day15.ui.tab_activity.LiveActivity;
import com.example.day15.ui.tab_activity.WelfareActivity;
import com.google.android.material.tabs.TabLayout;
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
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_tab, parent, false);
            return new ViewHolder2(view2);
        } else if (viewType == 2) {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item_butten, parent, false);
            return new ViewHolder3(view3);
        } else {
            View view4 = LayoutInflater.from(context).inflate(R.layout.item_rlv, parent, false);

            return new ViewHolder4(view4);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
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

        } else if (type == 1) {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.tab.addTab(holder2.tab.newTab().setText("课程").setIcon(R.mipmap.course_icon));
            holder2.tab.addTab(holder2.tab.newTab().setText("直播").setIcon(R.mipmap.live_icon));
            holder2.tab.addTab(holder2.tab.newTab().setText("福利").setIcon(R.mipmap.suggest_icon));
            holder2.tab.addTab(holder2.tab.newTab().setText("答疑").setIcon(R.mipmap.agreement_icon));
            holder2.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()){
                        case 0:
                            context.startActivity(new Intent(context, CourseActivity.class));
                            break;
                        case 1:
                            context.startActivity(new Intent(context, LiveActivity.class));
                            break;
                        case 2:
                            context.startActivity(new Intent(context, WelfareActivity.class));
                            break;
                        case 3:
                            context.startActivity(new Intent(context, AnsweringActivity.class));
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        } else if (type == 2) {
            ViewHolder3 holder3 = (ViewHolder3) holder;
            holder3.iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, IvActivity.class));
                }
            });
            holder3.iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, IvActivity.class));
                }
            });
        }else if(type==3){
            ViewHolder4 holder4= (ViewHolder4) holder;
            holder4.rlv.setLayoutManager(new LinearLayoutManager(context));
            ArrayList<View> views = new ArrayList<>();
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_show_rlv, null);
            views.add(inflate);
            views.add(inflate);
            RlvAdapter rlvAdapter = new RlvAdapter(context,views);
            holder4.rlv.setAdapter(rlvAdapter);
            rlvAdapter.setOnclickListener(new RlvAdapter.onClickListener() {
                @Override
                public void onClick(int position) {
                    context.startActivity(new Intent(context,RlvActivity.class));
                }
            });
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

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tab;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab = (TabLayout) rootView.findViewById(R.id.tab);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv1;
        public ImageView iv2;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
            this.iv2 = (ImageView) rootView.findViewById(R.id.iv2);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rlv;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rlv = (RecyclerView) rootView.findViewById(R.id.rlv);
        }

    }
}
