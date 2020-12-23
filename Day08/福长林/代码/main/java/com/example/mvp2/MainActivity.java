package com.example.mvp2;

import android.os.Bundle;

import com.example.mvp2.base.activity.BaseActivity;
import com.example.mvp2.base.mvp.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void init() {
        tablayout.addTab(tablayout.newTab().setText("首页").setIcon(R.drawable.selector_home));
        tablayout.addTab(tablayout.newTab().setText("发现").setIcon(R.drawable.selector_discover));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.add));
        tablayout.addTab(tablayout.newTab().setText("商城").setIcon(R.drawable.selector_shop));
        tablayout.addTab(tablayout.newTab().setText("我的").setIcon(R.drawable.selector_my));

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_main;
    }


}
