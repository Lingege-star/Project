package com.example.day05_test_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day05_test_01.R;
import com.example.day05_test_01.bean.Bean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RcyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean> list;

    public RcyAdapter(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    private final static int TYPE_ONE = 0;
    private final static int TYPE_TWO = 1;
    private final static int TYPE_THREE = 2;
    private final static int TYPE_FOUR = 3;
    private final static int TYPE_FIVE = 4;
    private final static int TYPE_SIX = 5;
    private final static int TYPE_SEVEN = 6;

    @Override
    public int getItemViewType(int position) {
        if (position == TYPE_ONE) {
            return TYPE_ONE;
        } else if (position == TYPE_TWO) {
            return TYPE_TWO;
        } else if (position == TYPE_THREE) {
            return TYPE_THREE;
        } else if (position == TYPE_FOUR) {
            return TYPE_FOUR;
        } else if (position == TYPE_FIVE) {
            return TYPE_FIVE;
        } else if (position == TYPE_SIX) {
            return TYPE_SIX;
        } else {
            return TYPE_SEVEN;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_ONE) {
            return new ViewHolder0(inflater.inflate(R.layout.item_one, parent, false));

        } else if (viewType == TYPE_TWO) {
            return new ViewHolder1(inflater.inflate(R.layout.item_two, parent, false));

        } else if (viewType == TYPE_THREE) {
            return new ViewHolder2(inflater.inflate(R.layout.item_three, parent, false));

        } else if (viewType == TYPE_FOUR) {
            return new ViewHolder3(inflater.inflate(R.layout.item_four, parent, false));


        } else if (viewType == TYPE_FIVE) {
            return new ViewHolder4(inflater.inflate(R.layout.item_five, parent, false));


        } else if (viewType == TYPE_SIX) {
            return new ViewHolder5(inflater.inflate(R.layout.item_six, parent, false));
        } else {
            return new ViewHolder6(inflater.inflate(R.layout.item_seven, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_ONE) {
            ViewHolder0 oneHolder = (ViewHolder0) holder;
            Glide.with(context).load(R.drawable.a03).into(oneHolder.iv_image_item_one);

        } else if (viewType == TYPE_TWO) {
            ViewHolder1 twoHolder = (ViewHolder1) holder;
            TabLayout layout_two = twoHolder.tl_tabLayout_two;
            layout_two.addTab(layout_two.newTab().setText("每日推荐").setIcon(R.drawable.a04));
            layout_two.addTab(layout_two.newTab().setText("飞花令").setIcon(R.drawable.a05));
            layout_two.addTab(layout_two.newTab().setText("诗歌社群").setIcon(R.drawable.a06));
            layout_two.addTab(layout_two.newTab().setText("排行榜").setIcon(R.drawable.a07));
            layout_two.addTab(layout_two.newTab().setText("会员专区").setIcon(R.drawable.a08));

        } else if (viewType == TYPE_THREE) {
            ViewHolder2 threeHolder = (ViewHolder2) holder;


        } else if (viewType == TYPE_FOUR) {
            ViewHolder3 four = (ViewHolder3) holder;

        } else if (viewType == TYPE_FIVE) {
            ViewHolder4 five = (ViewHolder4) holder;
        } else if (viewType == TYPE_SIX) {
            ViewHolder5 six = (ViewHolder5) holder;
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_image_item_one;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_image_item_one = (ImageView) rootView.findViewById(R.id.iv_image_item_one);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tl_tabLayout_two;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tl_tabLayout_two = (TabLayout) rootView.findViewById(R.id.tl_tabLayout_two);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tv1_three;
        public ImageView iv_iv1_three;
        public ImageView iv_iv2_three;
        public ImageView iv_iv3_three;
        public TextView tv_tv2_three;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tv1_three = (TextView) rootView.findViewById(R.id.tv_tv1_three);
            this.iv_iv1_three = (ImageView) rootView.findViewById(R.id.iv_iv1_three);
            this.iv_iv2_three = (ImageView) rootView.findViewById(R.id.iv_iv2_three);
            this.iv_iv3_three = (ImageView) rootView.findViewById(R.id.iv_iv3_three);
            this.tv_tv2_three = (TextView) rootView.findViewById(R.id.tv_tv2_three);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tv1_four;
        public TextView tv_tv2_four;
        public RecyclerView rcy_recycler_four;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tv1_four = (TextView) rootView.findViewById(R.id.tv_tv1_four);
            this.tv_tv2_four = (TextView) rootView.findViewById(R.id.tv_tv2_four);
            this.rcy_recycler_four = (RecyclerView) rootView.findViewById(R.id.rcy_recycler_four);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tv1_five;
        public TextView tv_tv2_five;
        public RecyclerView rcy_recycler_five;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tv1_five = (TextView) rootView.findViewById(R.id.tv_tv1_five);
            this.tv_tv2_five = (TextView) rootView.findViewById(R.id.tv_tv2_five);
            this.rcy_recycler_five = (RecyclerView) rootView.findViewById(R.id.rcy_recycler_five);
        }

    }

    public static
    class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tv1_six;
        public TextView tv_tv2_six;
        public RecyclerView rcy_recycler_five;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tv1_six = (TextView) rootView.findViewById(R.id.tv_tv1_six);
            this.tv_tv2_six = (TextView) rootView.findViewById(R.id.tv_tv2_six);
            this.rcy_recycler_five = (RecyclerView) rootView.findViewById(R.id.rcy_recycler_five);
        }

    }

    public static
    class ViewHolder6 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tv1_seven;
        public RecyclerView rcy_recycler_seven;

        public ViewHolder6(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tv1_seven = (TextView) rootView.findViewById(R.id.tv_tv1_seven);
            this.rcy_recycler_seven = (RecyclerView) rootView.findViewById(R.id.rcy_recycler_seven);
        }

    }
}
