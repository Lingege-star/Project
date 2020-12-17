package com.example.zuo_03.view;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zuo_03.R;
import com.example.zuo_03.view.fragment.BlankFragment;
import com.example.zuo_03.view.fragment.BlankFragment2;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private TabLayout tab;
    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl,blankFragment)
                .add(R.id.fl,blankFragment2)
                .show(blankFragment)
                .hide(blankFragment2)
                .commit();
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("沙发"));
        tab.addTab(tab.newTab().setText("发现"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment)
                                .hide(blankFragment2)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment)
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
