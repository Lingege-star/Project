package com.example.Day02.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.Day02.R;
import com.example.Day02.bean.ReBean;

import java.util.ArrayList;

class ReAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ReBean.DataBean> list;

    public ReAdapter(Context context, ArrayList<ReBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_re_meng, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ReBean.DataBean dataBean = list.get(position);
        viewHolder.dass.setText(dataBean.getLocation());
        viewHolder.name.setText(dataBean.getTitle());
        viewHolder.temr.setText(dataBean.getStartTime());
        Glide.with(context).load(dataBean.getCover()).apply(new RequestOptions().transform(new RoundedCorners(10))).into(viewHolder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView name;
        public TextView dass;
        public TextView temr;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.dass = (TextView) rootView.findViewById(R.id.dass);
            this.temr = (TextView) rootView.findViewById(R.id.temr);
        }

    }
}
