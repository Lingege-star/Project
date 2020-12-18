package com.example.day04_test_01;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.day04_test_01.fragment.ActivityFragment;
import com.example.day04_test_01.fragment.DiscoverFragment;
import com.example.day04_test_01.fragment.HomeFragment;
import com.example.day04_test_01.fragment.MeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_fragment_main;
    private TabLayout tl_tabLayout_main;
    private ArrayList<Fragment> fragments;
    private int hideIndex;
    private FragmentManager fragmentManager;
    private TextView tv_toolBar_main;
    private Toolbar tb_toolbar_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addTabAndFragment();
    }

    private void addTabAndFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new ActivityFragment());
        fragments.add(new MeFragment());

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_fragment_main, fragments.get(0))
                .commit();

        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("首页"));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("发现"));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("活动"));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("我的"));

        tl_tabLayout_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tv_toolBar_main.setText(tab.getText());
                showFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void showFragment(int position) {
        Fragment showFragment = fragments.get(position);
        Fragment hideFragment = fragments.get(hideIndex);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!showFragment.isAdded()) {
            transaction.add(R.id.fl_fragment_main, showFragment);
        }
        transaction.show(showFragment)
                .hide(hideFragment)
                .commit();
        hideIndex = position;
    }

    private void initView() {
        fl_fragment_main = (FrameLayout) findViewById(R.id.fl_fragment_main);
        tl_tabLayout_main = (TabLayout) findViewById(R.id.tl_tabLayout_main);

        tv_toolBar_main = (TextView) findViewById(R.id.tv_toolBar_main);
        tb_toolbar_main = (Toolbar) findViewById(R.id.tb_toolbar_main);
        setSupportActionBar(tb_toolbar_main);
        tb_toolbar_main.setTitle(" ");
    }
}