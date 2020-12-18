package com.example.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.MyInterface;
import com.example.activity.PaoziActivity;
import com.example.activity.TopActivity;
import com.example.activity.TuanActivity;
import com.example.adapter.HotAdapter;
import com.example.base.BaseFragment;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;
import com.example.lianxi4.R;
import com.example.presenter.MyPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FoundFragment extends BaseFragment<MyPersenter> implements MyInterface.view, View.OnClickListener {

    private RecyclerView rcy;
    private TabLayout tab;
    private TextView papzi;
    private TextView tuan;
    private TextView top;
    private ViewPager vp;
    private ArrayList<HotInfo.DataBean> hotlist;
    private ArrayList<TabInfo.DataBean> tablist;
    private ArrayList<Fragment> fragments;

    @Override
    protected int getLayout() {
        return R.layout.fragment_found;
    }

    @Override
    protected void initView() {
        rcy = getActivity().findViewById(R.id.rcy);
        tab = getActivity().findViewById(R.id.tab);
        papzi = getActivity().findViewById(R.id.paozi);
        tuan = getActivity().findViewById(R.id.tuan);
        top = getActivity().findViewById(R.id.top);
        vp = getActivity().findViewById(R.id.vp);
        papzi.setOnClickListener(this);
        tuan.setOnClickListener(this);
        top.setOnClickListener(this);
        hotlist = new ArrayList<>();
        tablist = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Override
    protected void initData() {
        pPresenter.gethot();
        pPresenter.gettab();
    }

    @Override
    protected MyPersenter createPresenter() {
        return new MyPersenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paozi:
                        startActivity(new Intent(getActivity(), PaoziActivity.class));
                break;
            case R.id.tuan:
                startActivity(new Intent(getActivity(), TuanActivity.class));
                break;
            case R.id.top:
                startActivity(new Intent(getActivity(), TopActivity.class));
                break;

        }

    }

    @Override
    public void gethot(HotInfo hotInfo) {
        if (hotInfo != null) {
            hotlist.addAll(hotInfo.getData());
        }
        HotAdapter hotAdapter = new HotAdapter(getContext(), hotlist);
        rcy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcy.setAdapter(hotAdapter);
        hotAdapter.notifyDataSetChanged();
    }

    @Override
    public void gettab(TabInfo tabInfo) {
                if (tabInfo!=null){
                    tablist.addAll(tabInfo.getData());
                }
        for (int i = 0; i <tablist.size(); i++) {
            fragments.add(new BlankFragment(tablist.get(i).getType()));
        }
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position).getName();
            }
        });
        tab.setupWithViewPager(vp);


    }

    @Override
    public void getnews(NewsInfo newsInfo) {

    }


}
