package com.example.a1218lian;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.a1218lian.adapter.MainVpAdapter;
import com.example.a1218lian.fragment.FindFragment;
import com.example.a1218lian.fragment.MoreFragment;
import com.example.a1218lian.fragment.MyFragment;
import com.example.a1218lian.fragment.ShowFragment;
import com.example.a1218lian.fragment.SoftFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> list;
    private MainVpAdapter mainVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);

        list = new ArrayList<>();
        list.add(new ShowFragment());
        list.add(new SoftFragment());
        list.add(new MoreFragment());
        list.add(new FindFragment());
        list.add(new MyFragment());
        mainVpAdapter = new MainVpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(mainVpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
