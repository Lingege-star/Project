package com.example.day06.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day06.R;
import com.example.day06.map.Manager.ContainManager;
import com.example.day06.map.base.App;
import com.example.day06.map.base.BaseActivity;
import com.example.day06.map.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private boolean TUICHU;
    private Handler handler = new Handler();
    private int[] mTabs = {R.string.Homefrg_view, R.string.Showfrg_view,R.string.Shangfrg_view,R.string.Myfrg_view};


    @Override
    protected void init() {
        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(),getFragments(),mTabs);
        vp.setAdapter(homeAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.c1);
        tab.getTabAt(1).setIcon(R.drawable.c2);
        tab.getTabAt(2).setIcon(R.drawable.c3);
        tab.getTabAt(3).setIcon(R.drawable.c4);
    }
    private ArrayList<Fragment> getFragments(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ShowFragment());
        list.add(new ShangFragment());
        list.add(new MyFragment());
        return list;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }



    @Override
    protected void click(View view) {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }


    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!TUICHU) {
                TUICHU = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TUICHU = false;
                    }
                }, 2000);
            } else {
                ContainManager.getManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again

    }
}
