package com.example.myapplication.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.app.App;
import com.example.myapplication.base.BaseAcyivity;
import com.example.myapplication.base.IBaseView;
import com.example.myapplication.mannager.ContionMannager;
import com.example.myapplication.presenter.MyPresenter;
import com.example.myapplication.ui.fragment.AddFragment;
import com.example.myapplication.ui.fragment.FoundFragment;
import com.example.myapplication.ui.fragment.MainFragment;
import com.example.myapplication.ui.fragment.MallFragment;
import com.example.myapplication.ui.fragment.MineFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAcyivity<MyPresenter> implements IBaseView {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    private Boolean is = false;
    private Handler handler = new Handler();
    private ArrayList<Fragment> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void OnClick(View view) {

    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter(this);
    }


    @Override
    protected void init() {
        list = new ArrayList<>();
        list.add(new MainFragment());
        list.add(new FoundFragment());
        list.add(new AddFragment());
        list.add(new MallFragment());
        list.add(new MineFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.select_me).setText(R.string.main);
        tab.getTabAt(1).setIcon(R.drawable.select_home).setText(R.string.fount);
        tab.getTabAt(2).setIcon(R.drawable.add);
        tab.getTabAt(3).setIcon(R.drawable.select_find).setText(R.string.mall);
        tab.getTabAt(4).setIcon(R.drawable.select_me).setText(R.string.mine);
    }

    @Override
    protected void initData() {
        getmPresenter().start();
    }

    @Override
    public void OnSucess(Object o) {
        String s = (String) o;
        Log.e("TAG", "OnSucess: 请求成功" + s);
    }

    @Override
    public void OnFile(String msg) {
        Log.e("TAG", "OnFile: 失败" + msg);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!is) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                is = true;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        is = false;
                    }
                }, 2000);
            } else {
                ContionMannager.getMannager().clearactivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
