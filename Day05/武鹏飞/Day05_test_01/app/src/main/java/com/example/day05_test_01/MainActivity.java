package com.example.day05_test_01;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day05_test_01.adapter.RcyAdapter;
import com.example.day05_test_01.bean.Bean;
import com.example.day05_test_01.fragment.HomeFragment;
import com.example.day05_test_01.fragment.MeFragment;
import com.example.day05_test_01.fragment.PicFragment;
import com.example.day05_test_01.fragment.PopemFragment;
import com.example.day05_test_01.fragment.WorksFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_frame_main;
    private TabLayout tl_tabLayout_main;
    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    private int hideIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        AddTabAndFragment();
    }

    private void AddTabAndFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PopemFragment());
        fragments.add(new PicFragment());
        fragments.add(new WorksFragment());
        fragments.add(new MeFragment());

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_frame_main,fragments.get(0))
                .commit();

        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("首页").setIcon(R.drawable.a26));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("写诗").setIcon(R.drawable.a27));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("传图").setIcon(R.drawable.a30));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("作品").setIcon(R.drawable.a28));
        tl_tabLayout_main.addTab(tl_tabLayout_main.newTab().setText("我的").setIcon(R.drawable.a29));

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