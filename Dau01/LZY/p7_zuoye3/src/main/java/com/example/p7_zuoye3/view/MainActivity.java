package com.example.p7_zuoye3.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.p7_zuoye3.view.fragment.FaXianFragment;
import com.example.p7_zuoye3.view.fragment.HomeFragment;
import com.example.p7_zuoye3.model.adapter.MainVpAdapter;
import com.example.p7_zuoye3.view.fragment.MyFragment;
import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.view.fragment.ShaFaFragment;
import com.example.p7_zuoye3.view.fragment.WuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private TabLayout tl_main;
    private ArrayList<Fragment> list;
    private MainVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tl_main = (TabLayout) findViewById(R.id.tl_main);
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ShaFaFragment());
        list.add(new WuFragment());
        list.add(new FaXianFragment());
        list.add(new MyFragment());
        adapter = new MainVpAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        vp_main.setAdapter(adapter);
        tl_main.setupWithViewPager(vp_main);
        tl_main.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tl_main.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tl_main.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tl_main.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tl_main.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}
