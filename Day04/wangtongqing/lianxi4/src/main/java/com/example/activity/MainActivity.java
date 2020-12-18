package com.example.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragment.AddFragment;
import com.example.fragment.MainFragment;
import com.example.fragment.MallFragment;
import com.example.fragment.MineFragment;
import com.example.lianxi4.R;
import com.example.fragment.FoundFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private MainFragment mainFragment;
    private FoundFragment foundFragment;
    private AddFragment addFragment;
    private MallFragment mallFragment;
    private MineFragment mineFragment;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        mainFragment = new MainFragment();
        foundFragment = new FoundFragment();
        addFragment = new AddFragment();
        mallFragment = new MallFragment();
        mineFragment = new MineFragment();
        tab.addTab(tab.newTab().setText("首页"));
        tab.addTab(tab.newTab().setText("发现"));
        tab.addTab(tab.newTab().setIcon(R.drawable.add));
        tab.addTab(tab.newTab().setText("商城"));
        tab.addTab(tab.newTab().setText("我的"));
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction
                .add(R.id.fl,mainFragment)
                .add(R.id.fl,foundFragment)
                .add(R.id.fl,addFragment)
                .add(R.id.fl,mallFragment)
                .add(R.id.fl,mineFragment)
                .hide(foundFragment)
                .hide(addFragment)
                .hide(mallFragment)
                .hide(mineFragment)
                .commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        transaction.show(mainFragment)
                                .hide(foundFragment)
                                .hide(addFragment)
                                .hide(mallFragment)
                                .hide(mineFragment);
                        break;
                    case 1:
                        transaction.show(foundFragment)
                                .hide(mainFragment)
                                .hide(addFragment)
                                .hide(mallFragment)
                                .hide(mineFragment);
                        break;
                    case 2:
                        transaction.show(addFragment)
                                .hide(mainFragment)
                                .hide(foundFragment)
                                .hide(mallFragment)
                                .hide(mineFragment);
                        break;
                    case 3:
                        transaction.show(mallFragment)
                                .hide(mainFragment)
                                .hide(foundFragment)
                                .hide(addFragment)
                                .hide(mineFragment);
                        break;
                    case 4:
                        transaction.show(mineFragment)
                                .hide(mainFragment)
                                .hide(foundFragment)
                                .hide(addFragment)
                                .hide(mallFragment);
                        break;
                }
                transaction.commit();
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
