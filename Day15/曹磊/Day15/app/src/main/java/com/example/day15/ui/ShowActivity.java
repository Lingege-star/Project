package com.example.day15.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day15.R;
import com.example.day15.ui.fragment.HomeFragment;
import com.example.day15.ui.fragment.ShowFragment;
import com.example.day15.ui.fragment.XuanFragment;
import com.example.day15.ui.fragment.XueFragment;
import com.google.android.material.tabs.TabLayout;

public class ShowActivity extends AppCompatActivity {


    private FrameLayout fl;
    private ShowFragment showFragment;
    private HomeFragment homeFragment;
    private TabLayout tab;
    private XuanFragment xuanFragment;
    private XueFragment xueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
    }

    private void initView() {

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
        tab.addTab(tab.newTab().setText("首页"));
        tab.addTab(tab.newTab().setText("选课"));
        tab.addTab(tab.newTab().setText("学习"));
        tab.addTab(tab.newTab().setText("我的"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show(showFragment)
                                .hide(xuanFragment)
                                .hide(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .show(xuanFragment)
                                .hide(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .hide(showFragment)
                                .hide(xuanFragment)
                                .show(xueFragment)
                                .hide(homeFragment)
                                .commit();
                        break;
                    case 3:
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
}