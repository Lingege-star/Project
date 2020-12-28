package com.example.jpush_test.dome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jpush_test.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;
    private ArrayList<Integer> img;

    public RlvAdapter(Context context, ArrayList<View> list) {
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
        } else if (position == 3) {
            return 3;
        } else {
            return 4;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_0, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_1, parent, false);
            return new ViewHolder2(view2);
        } else if (viewType == 2) {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item_2, parent, false);
            return new ViewHolder3(view3);
        } else if (viewType == 3) {
            View view4 = LayoutInflater.from(context).inflate(R.layout.item_3, parent, false);
            return new ViewHolder4(view4);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;

            img = new ArrayList<>();
            img.add(R.drawable.a1);
            img.add(R.drawable.a2);
            img.add(R.drawable.a3);
            viewHolder1.banner.setImages(img).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
        } else if (type == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.fan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是翻译", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder2.ming.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是名宿", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (type == 2) {
            ViewHolder3 viewHolder3 = (ViewHolder3) holder;
            viewHolder3.rlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true));
            ArrayList<View> views = new ArrayList<>();
            View view = LayoutInflater.from(context).inflate(R.layout.item_my, null);
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_my, null);
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_my, null);
            View view3 = LayoutInflater.from(context).inflate(R.layout.item_my, null);
            views.add(view);
            views.add(view1);
            views.add(view2);
            views.add(view3);
            MyAdapter myAdapter = new MyAdapter(context, views);
            viewHolder3.rlv.setAdapter(myAdapter);

        } else if (type == 3) {

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
        public Button ming;
        public Button fan;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ming = (Button) rootView.findViewById(R.id.ming);
            this.fan = (Button) rootView.findViewById(R.id.fan);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rlv;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rlv = (RecyclerView) rootView.findViewById(R.id.rlv);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_img;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }
}
