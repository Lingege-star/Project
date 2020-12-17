package com.example.day03_test01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_test01.R;
import com.example.day03_test01.bean.TestBean;

import java.util.ArrayList;

public class TextRcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TestBean.DataBeanX.DataBean> list;

    public TextRcyAdapter(Context context, ArrayList<TestBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title_item_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title_item_text = (TextView) rootView.findViewById(R.id.tv_title_item_text);
        }

    }
}
