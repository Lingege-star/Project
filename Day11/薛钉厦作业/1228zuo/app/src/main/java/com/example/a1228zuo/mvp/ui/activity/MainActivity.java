package com.example.a1228zuo.mvp.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.a1228zuo.R;
import com.example.a1228zuo.mvp.ui.adapter.MainVpAdapter;
import com.example.a1228zuo.mvp.ui.fragment.GongluFragment;
import com.example.a1228zuo.mvp.ui.fragment.MyFragment;
import com.example.a1228zuo.mvp.ui.fragment.ShowFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_tol_tv)
    TextView mainTolTv;
    @BindView(R.id.main_tol_img)
    ImageView mainTolImg;
    @BindView(R.id.tol)
    Toolbar tol;
    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.main_tab)
    TabLayout mainTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShowFragment());
        fragments.add(new GongluFragment());
        fragments.add(new MyFragment());
        MainVpAdapter mainVpAdapter = new MainVpAdapter(getSupportFragmentManager(),fragments);
        mainVp.setAdapter(mainVpAdapter);

        mainTab.setupWithViewPager(mainVp);
        mainTab.getTabAt(0).setText("首页").setIcon(R.drawable.main_show);
        mainTab.getTabAt(1).setText("攻略").setIcon(R.drawable.main_gonglv);
        mainTab.getTabAt(2).setText("我的").setIcon(R.drawable.main_my);

        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String s = tab.getText().toString();
                mainTolTv.setText(s);
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
