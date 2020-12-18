package com.example.fuchanglin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.fuchanglin.Fragment.TongPaoActivity.DiscoverFragment;
import com.example.fuchanglin.Fragment.TongPaoActivity.HomeFragment;
import com.example.fuchanglin.Fragment.TongPaoActivity.MyFragment;
import com.example.fuchanglin.Fragment.TongPaoActivity.ShopFragment;
import com.example.fuchanglin.R;
import com.google.android.material.tabs.TabLayout;

public class TongPaoActivity extends AppCompatActivity {

    private FrameLayout rl;
    private TabLayout tabb;
    private HomeFragment homeFragment;
    private MyFragment myFragment;
    private DiscoverFragment discoverFragment;
    private ShopFragment shopFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_pao);
        initView();
    }

    private void initView() {
        rl = (FrameLayout) findViewById(R.id.rl);
        tabb = (TabLayout) findViewById(R.id.tabb);

        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        discoverFragment = new DiscoverFragment();
        myFragment = new MyFragment();

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.rl, homeFragment)
                .add(R.id.rl, discoverFragment)
                .add(R.id.rl, shopFragment)
                .add(R.id.rl, myFragment)
                .show(homeFragment)
                .hide(discoverFragment)
                .hide(shopFragment)
                .hide(myFragment)
                .commit();

        tabb.addTab(tabb.newTab().setText("首页").setIcon(R.drawable.selector_home));
        tabb.addTab(tabb.newTab().setText("发现").setIcon(R.drawable.selector_discover));
        tabb.addTab(tabb.newTab().setIcon(R.drawable.add));
        tabb.addTab(tabb.newTab().setText("商城").setIcon(R.drawable.selector_shop));
        tabb.addTab(tabb.newTab().setText("我的").setIcon(R.drawable.selector_my));

        tabb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        transaction1.show(homeFragment)
                                .hide(discoverFragment)
                                .hide(shopFragment)
                                .hide(myFragment);
                        break;
                    case 1:
                        transaction1.show(discoverFragment)
                                .hide(homeFragment)
                                .hide(shopFragment)
                                .hide(myFragment);
                        break;
                    case 2:
                        startActivity(new Intent(TongPaoActivity.this,AddActivity.class));
                        break;
                    case 3:
                        transaction1.show(shopFragment)
                                .hide(homeFragment)
                                .hide(discoverFragment)
                                .hide(myFragment);
                        break;
                    case 4  :
                        transaction1.show(myFragment)
                                .hide(discoverFragment)
                                .hide(homeFragment)
                                .hide(shopFragment);
                        break;
                }
                transaction1.commit();
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
