package com.example.xieshi;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.xieshi.fragment.MainFragment;
import com.example.xieshi.fragment.MineFragment;
import com.example.xieshi.fragment.PicFragment;
import com.example.xieshi.fragment.PoemFragment;
import com.example.xieshi.fragment.WorksFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView searchview;
    private ImageView iv_a;
    private ImageView iv_b;
    private TabLayout tab;
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private PoemFragment poemFragment;
    private PicFragment picFragment;
    private WorksFragment worksFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        searchview = (SearchView) findViewById(R.id.searchview);
        iv_a = (ImageView) findViewById(R.id.iv_a);
        iv_b = (ImageView) findViewById(R.id.iv_b);
        tab = (TabLayout) findViewById(R.id.tab);
        mainFragment = new MainFragment();
        poemFragment = new PoemFragment();
        picFragment = new PicFragment();
        worksFragment = new WorksFragment();
        mineFragment = new MineFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl,mainFragment)
                .add(R.id.fl,poemFragment)
                .add(R.id.fl,picFragment)
                .add(R.id.fl,worksFragment)
                .add(R.id.fl,mineFragment)
                .hide(poemFragment)
                .hide(picFragment)
                .hide(worksFragment)
                .hide(mineFragment)
                .commit();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.main));
        tab.addTab(tab.newTab().setText("写诗").setIcon(R.drawable.main));
        tab.addTab(tab.newTab().setText("传图").setIcon(R.drawable.main));
        tab.addTab(tab.newTab().setText("作品").setIcon(R.drawable.main));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.main));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        beginTransaction.show(mainFragment)
                                .hide(poemFragment)
                                .hide(picFragment)
                                .hide(worksFragment)
                                .hide(mineFragment);
                        break;
                    case 1:
                        beginTransaction.show(poemFragment)
                                .hide(mainFragment)
                                .hide(picFragment)
                                .hide(worksFragment)
                                .hide(mineFragment);
                        break;
                    case 2:
                        beginTransaction.show(picFragment)
                                .hide(mainFragment)
                                .hide(poemFragment)
                                .hide(worksFragment)
                                .hide(mineFragment);
                        break;
                    case 3:
                        beginTransaction.show(worksFragment)
                                .hide(mainFragment)
                                .hide(poemFragment)
                                .hide(picFragment)
                                .hide(mineFragment);
                        break;
                    case 4:
                        beginTransaction.show(mineFragment)
                                .hide(mainFragment)
                                .hide(poemFragment)
                                .hide(picFragment)
                                .hide(worksFragment);
                        break;
                }
                beginTransaction.commit();
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
