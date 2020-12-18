package com.example.day04_test_01.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.day04_test_01.R;
import com.example.day04_test_01.bean.EventsBean;
import com.example.day04_test_01.bean.TabBean;
import com.example.day04_test_01.fragment.ItemFragment;
import com.example.day04_test_01.net.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RcyAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RcyAdapter";
    private Context context;
    private ArrayList<TabBean.DataBean> tabList;
    private ArrayList<EventsBean.DataBean> list;
    private EventRcyAdapter eventRcyAdapter;
    private ArrayList<Fragment> fragments;


    public RcyAdapter(Context context, ArrayList<TabBean.DataBean> tabList, ArrayList<EventsBean.DataBean> list) {
        this.context = context;
        this.tabList = tabList;
        this.list = list;
    }

    private final static int TYPE_ONE = 0;
    private final static int TYPE_TWO = 1;
    private final static int TYPE_THREE = 2;

    @Override
    public int getItemViewType(int position) {
        if (position == TYPE_ONE) {
            return TYPE_ONE;
        } else if (position == TYPE_TWO) {
            return TYPE_TWO;
        } else {
            return TYPE_THREE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_ONE) {
            View oneView = inflater.inflate(R.layout.item_one, parent, false);
            return new ViewHolder0(oneView);
        } else if (viewType == TYPE_TWO) {
            View twoView = inflater.inflate(R.layout.item_two, parent, false);
            return new ViewHolder1(twoView);
        } else {
            View threeView = inflater.inflate(R.layout.item_three, parent, false);
            return new ViewHolder2(threeView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_ONE) {
            tabHolder(holder, position);
        } else if (viewType == TYPE_TWO) {
            twoRecycler(holder, position);
        } else {
            threeTab(holder, position);
        }
    }

    private void threeTab(RecyclerView.ViewHolder holder, int position) {
        ViewHolder2 threeHolder = (ViewHolder2) holder;
        TabLayout tl_tabLayout_three = threeHolder.tl_tabLayout_three;
        ViewPager vp_viewPager_three = threeHolder.vp_viewPager_three;
        fragments = new ArrayList<>();
        for (int i = 0; i < tabList.size(); i++) {
            ItemFragment itemFragment = new ItemFragment();
            fragments.add(itemFragment);
            tl_tabLayout_three.addTab(tl_tabLayout_three.newTab().setText(tabList.get(i).getName()));
            Sourcetree
        }


    }

    private void twoRecycler(RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 twoHolder = (ViewHolder1) holder;
        RecyclerView rv_recycler_two = twoHolder.rv_recycler_two;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_recycler_two.setLayoutManager(manager);
        ArrayList<EventsBean.DataBean> dataBeans = new ArrayList<>();
        eventRcyAdapter = new EventRcyAdapter(context, dataBeans);
        rv_recycler_two.setAdapter(eventRcyAdapter);
        initData();

    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<EventsBean>() {
                    @Override
                    public void onNext(EventsBean eventsBean) {
                        eventRcyAdapter.addData(eventsBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "onError: " + t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void tabHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder0 oneHolder = (ViewHolder0) holder;
        TabLayout tl_tabLayout_one = oneHolder.tl_tabLayout_one;
        tl_tabLayout_one.addTab(tl_tabLayout_one.newTab().setText("袍子"));
        tl_tabLayout_one.addTab(tl_tabLayout_one.newTab().setText("社团"));
        tl_tabLayout_one.addTab(tl_tabLayout_one.newTab().setText("排行榜"));
    }

    @Override
    public int getItemCount() {
        return tabList.size();
    }

    public void addData(List<TabBean.DataBean> data) {
        if (data != null && data.size() > 0) {
            tabList.addAll(data);
            notifyDataSetChanged();
        }
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tl_tabLayout_one;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tl_tabLayout_one = (TabLayout) rootView.findViewById(R.id.tl_tabLayout_one);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title_two;
        public RecyclerView rv_recycler_two;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title_two = (TextView) rootView.findViewById(R.id.tv_title_two);
            this.rv_recycler_two = (RecyclerView) rootView.findViewById(R.id.rv_recycler_two);
        }

    }


    public static
    class ViewHolder2 extends EventRcyAdapter.ViewHolder {
        public View rootView;
        public TabLayout tl_tabLayout_three;
        public ViewPager vp_viewPager_three;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tl_tabLayout_three = (TabLayout) rootView.findViewById(R.id.tl_tabLayout_three);
            this.vp_viewPager_three = (ViewPager) rootView.findViewById(R.id.vp_viewPager_three);
        }

    }
}
