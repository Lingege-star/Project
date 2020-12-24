package com.example.day08.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;

    public RlvAdapter(Context context, ArrayList<View> list) {
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
            View view = LayoutInflater.from(context).inflate(R.layout.item_tab, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder viewHolder= (ViewHolder) holder;
            viewHolder.tab.addTab(viewHolder.tab.newTab().setText("袍子").setIcon(R.drawable.a1));
            viewHolder.tab.addTab(viewHolder.tab.newTab().setText("推荐").setIcon(R.drawable.a2));
            viewHolder.tab.addTab(viewHolder.tab.newTab().setText("排行榜").setIcon(R.drawable.a3));
            viewHolder.tab.addTab(viewHolder.tab.newTab().setText("搜索").setIcon(R.drawable.a4));
            viewHolder.tab.addTab(viewHolder.tab.newTab().setText("定位").setIcon(R.drawable.a5));
            viewHolder.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()){
                        case 0:
                            Toast.makeText(context, "袍子", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(context, "推荐", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(context, "排行榜", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(context, "定位", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context,DituActivity.class));
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
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tab;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab = (TabLayout) rootView.findViewById(R.id.tab);
        }

    }
}
