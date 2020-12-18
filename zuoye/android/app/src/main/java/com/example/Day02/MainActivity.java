package com.example.Day02;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.Day02.fragment.BlankFragment;
import com.example.Day02.fragment.BlankFragment2;
import com.example.Day02.fragment.BlankFragment3;
import com.example.Day02.fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new BlankFragment());
        list.add(new BlankFragment2());
        list.add(new BlankFragment3());
        list.add(new BlankFragment4());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        vp.setAdapter(vpAdapter);
        tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页");
        tab.getTabAt(1).setText("发现");
        tab.getTabAt(2).setText("商城");
        tab.getTabAt(3).setText("我的");
    }
}
