package com.example.tongpao.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.tongpao.R;
import com.example.tongpao.adapter.RlvAdapter;
import com.example.tongpao.base.activity.BaseActivity;
import com.example.tongpao.base.mvp.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.tv_home_find)
    TextView tvHomeFind;
    @BindView(R.id.home_iv_pao)
    ImageView homeIvPao;
    @BindView(R.id.tv_pao)
    TextView tvPao;
    @BindView(R.id.home_iv_she)
    ImageView homeIvShe;
    @BindView(R.id.tv_she)
    TextView tvShe;
    @BindView(R.id.home_iv_pai)
    ImageView homeIvPai;
    @BindView(R.id.tv_pai)
    TextView tvPai;
    @BindView(R.id.home_iv_tu)
    ImageView homeIvTu;
    @BindView(R.id.tv_tu)
    TextView tvTu;
    @BindView(R.id.home_iv_ding)
    ImageView homeIvDing;
    @BindView(R.id.tv_ding)
    TextView tvDing;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.jd)
    TextView jd;
    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.l1)
    RelativeLayout l1;
    @BindView(R.id.discover_tab)
    TabLayout discoverTab;
    @BindView(R.id.square_vp)
    ViewPager squareVp;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void init() {

        tablayout.addTab(tablayout.newTab().setText("首页").setIcon(R.drawable.selector_home));
        tablayout.addTab(tablayout.newTab().setText("发现").setIcon(R.drawable.selector_discover));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.add));
        tablayout.addTab(tablayout.newTab().setText("商城").setIcon(R.drawable.selector_shop));
        tablayout.addTab(tablayout.newTab().setText("我的").setIcon(R.drawable.selector_my));

        homeIvDing.setOnClickListener(this);
        homeIvPai.setOnClickListener(this);
        homeIvPao.setOnClickListener(this);
        homeIvShe.setOnClickListener(this);
        homeIvTu.setOnClickListener(this);

        new RlvAdapter();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getlayoutid() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_iv_pao:
                startActivity(new Intent(MainActivity.this,PaoActivity.class));
                break;
            case R.id.home_iv_she:
                startActivity(new Intent(MainActivity.this,SheActivity.class));
                break;
            case R.id.home_iv_pai:
                startActivity(new Intent(MainActivity.this,PaiActivity.class));
                break;
            case R.id.home_iv_tu:
                startActivity(new Intent(MainActivity.this,TuActivity.class));
                break;
            case R.id.home_iv_ding:
                startActivity(new Intent(MainActivity.this,DingActivity.class));
                break;
        }
    }
}
