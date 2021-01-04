package com.example.day15.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.example.day15.R;
import com.example.day15.Util.StatusBarUtil;
import com.example.day15.map.base.App;
import com.example.day15.map.base.BaseActivity;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.ui.fragment.HomeFragment;
import com.example.day15.ui.fragment.ShowFragment;
import com.example.day15.ui.fragment.XuanFragment;
import com.example.day15.ui.fragment.XueFragment;
import com.example.day15.ui.toolbar_activity.FindActivity;
import com.example.day15.ui.toolbar_activity.LoginActivity;
import com.example.day15.ui.toolbar_activity.ServicesActivity;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends BaseActivity {


    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tab)
    TabLayout tab;
    private ShowFragment showFragment;
    private HomeFragment homeFragment;
    private XuanFragment xuanFragment;
    private XueFragment xueFragment;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        getWindow().setNavigationBarColor(Color.BLACK);
//        StatusBarUtil.setStatusBarTrans(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.services);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(App.context(), ServicesActivity.class));
            }
        });

        tv = (TextView) findViewById(R.id.tv);
        tv.setText("首页");
        fl = (FrameLayout) findViewById(R.id.fl);
        showFragment = new ShowFragment();
        homeFragment = new HomeFragment();
        xuanFragment = new XuanFragment();
        xueFragment = new XueFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl, showFragment)
                .add(R.id.fl, xuanFragment)
                .add(R.id.fl, xueFragment)
                .add(R.id.fl, homeFragment)
                .show(showFragment)
                .hide(xuanFragment)
                .hide(xueFragment)
                .hide(homeFragment)
                .commit();


        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.item_home_select));
        tab.addTab(tab.newTab().setText("选课").setIcon(R.drawable.item_course_select));
        tab.addTab(tab.newTab().setText("学习").setIcon(R.drawable.item_learn_select));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.item_mine_select));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tv.setText("首页");
                        getSupportFragmentManager().beginTransaction()
                                .show(showFragment)
                                .hide(xuanFragment)
                                .hide(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 1:
                        tv.setText(tab.getText());
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .show(xuanFragment)
                                .hide(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 2:
                        tv.setText("我的" + tab.getText());
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(xuanFragment)
                                .show(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 3:
                        tv.setText(null);
                        getSupportFragmentManager().beginTransaction()
                                .show(homeFragment)
                                .hide(xuanFragment)
                                .hide(xueFragment)
                                .hide(showFragment)
                                .commit();
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


    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item_find:
                //查找
                startActivity(new Intent(App.context(), FindActivity.class));
                break;
            case R.id.item_login:
                //登录
                startActivity(new Intent(App.context(), LoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}