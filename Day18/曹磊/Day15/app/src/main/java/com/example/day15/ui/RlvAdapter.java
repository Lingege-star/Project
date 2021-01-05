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

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;

    public RlvAdapter(Context context, ArrayList<View> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_show_rlv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(R.drawable.kechengtu).into(holder1.iv);
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickListener.onClick(position);
            }
        });
    }
    public interface onClickListener{
        void onClick(int position);
    }
    private onClickListener onclickListener;

    public void setOnclickListener(onClickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder  extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
        }

    }
}
