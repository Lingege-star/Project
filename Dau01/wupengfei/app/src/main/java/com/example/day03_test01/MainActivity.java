package com.example.day03_test01;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.day03_test01.fragment.DiscoverFragment;
import com.example.day03_test01.fragment.HomeFragment;
import com.example.day03_test01.fragment.MeFragment;
import com.example.day03_test01.fragment.PlusFragment;
import com.example.day03_test01.fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_frame_main;
    private TabLayout tl_tabLayout_main;
    private ArrayList<Fragment> fragments;
    private int hideIndex;
    private FragmentManager fragmentManager;

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
        fragments.add(new SofaFragment());
        fragments.add(new PlusFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MeFragment());

        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("沙发").setIcon(R.drawable.icon_tab_sofa));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("").setIcon(R.drawable.icon_tab_publish));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("发现").setIcon(R.drawable.icon_tab_find));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_frame_main,fragments.get(0))
                .commit();

        tl_tabLayout_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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
        if (!showFragment.isAdded()){
            transaction.add(R.id.fl_frame_main,showFragment);
        }
        transaction.show(showFragment)
                .hide(hideFragment)
                .commit();
        hideIndex = position;
    }

    private void initView() {
        fl_frame_main = (FrameLayout) findViewById(R.id.fl_frame_main);
        tl_tabLayout_main = (TabLayout) findViewById(R.id.tl_tabLayout_main);
    }
}