package com.example.day12_17;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.day12_17.Activity.AddActivity;
import com.example.day12_17.Fragment.FindFragment;
import com.example.day12_17.Fragment.MyFragment;
import com.example.day12_17.Fragment.ShowFragment;
import com.example.day12_17.Fragment.SofaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout rl;
    private TabLayout tabb;
    private MyFragment my;
    private SofaFragment sofa;
    private FindFragment find;
    private ShowFragment show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rl = (FrameLayout) findViewById(R.id.rl);
        tabb = (TabLayout) findViewById(R.id.tabb);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        show = new ShowFragment();
        find = new FindFragment();
        sofa = new SofaFragment();
        my = new MyFragment();

        transaction
                .add(R.id.rl, sofa)
                .add(R.id.rl, find)
//                .add(R.id.rl, my)
                .show(sofa)
//                .hide(sofa)
                .hide(find)
//                .hide(my)
                .commit();
//        tabb.addTab(tabb.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        tabb.addTab(tabb.newTab().setText("沙发").setIcon(R.drawable.icon_tab_sofa));
//        tabb.addTab(tabb.newTab().setIcon(R.drawable.icon_tab_publish));
        tabb.addTab(tabb.newTab().setText("发现").setIcon(R.drawable.icon_tab_find));
//        tabb.addTab(tabb.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));

        tabb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        trans.show(sofa)
//                                .hide(sofa)
                                .hide(find)
//                                .hide(my)
                                .commit();
                        break;
                    case 1:
                        trans.show(find)
//                                .hide(show)
                                .hide(sofa)
//                                .hide(my)
                                .commit();
                        break;
//                    case 2:
//                        startActivity(new Intent(MainActivity.this, AddActivity.class));
//                        break;
//                    case 3:
//                        trans.show(find)
//                                .hide(sofa)
//                                .hide(show)
//                                .hide(my)
//                                .commit();
//                        break;
//                    case 4:
//                        trans.show(my)
//                                .hide(sofa)
//                                .hide(find)
//                                .hide(show)
//                                .commit();
//                        break;
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
