package com.example.p7_zuoye5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<View> list;

    public RecAdapter(Context context, ArrayList<View> list) {
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
        }
        return null;
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
        public SearchView searchview;
        public ImageView image1;
        public ImageView image2;
        public ImageView image3;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.searchview = (SearchView) rootView.findViewById(R.id.searchview);
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
            this.image2 = (ImageView) rootView.findViewById(R.id.image2);
            this.image3 = (ImageView) rootView.findViewById(R.id.image3);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image4;
        public TextView tv_1;
        public ImageView image5;
        public TextView tv_2;
        public ImageView image6;
        public TextView tv_3;
        public ImageView image7;
        public TextView tv_4;
        public ImageView image8;
        public TextView tv_5;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image4 = (ImageView) rootView.findViewById(R.id.image4);
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
            this.image5 = (ImageView) rootView.findViewById(R.id.image5);
            this.tv_2 = (TextView) rootView.findViewById(R.id.tv_2);
            this.image6 = (ImageView) rootView.findViewById(R.id.image6);
            this.tv_3 = (TextView) rootView.findViewById(R.id.tv_3);
            this.image7 = (ImageView) rootView.findViewById(R.id.image7);
            this.tv_4 = (TextView) rootView.findViewById(R.id.tv_4);
            this.image8 = (ImageView) rootView.findViewById(R.id.image8);
            this.tv_5 = (TextView) rootView.findViewById(R.id.tv_5);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_6;
        public TextView tv_7;
        public ImageView image9;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_6 = (TextView) rootView.findViewById(R.id.tv_6);
            this.tv_7 = (TextView) rootView.findViewById(R.id.tv_7);
            this.image9 = (ImageView) rootView.findViewById(R.id.image9);
        }

    }
}
