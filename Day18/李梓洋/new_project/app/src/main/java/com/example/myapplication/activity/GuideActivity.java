package com.example.myapplication.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.manager.ContainManager;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.myapplication.R;
import com.example.myapplication.StatusBarUtil;
import com.example.myapplication.adapter.VpAdapter;
import com.example.myapplication.bean.DeviceBean;
import com.example.myapplication.presenter.GuidePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {

    private static final String TAG = "GuideActivity";
    @BindView(R.id.guide_vp)
    ViewPager vp;
    private VpAdapter mAdapter;
    private ArrayList<Integer> imgs;
    private BasePresenter presenter;


    @Override
    protected BasePresenter createPresenter() {
        return new GuidePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void init() {
        StatusBarUtil.setStatusBarColor(this,R.color.white);
        mAdapter = new VpAdapter(getPageList(), this);
        vp.setAdapter(mAdapter);

        mAdapter.setMyClick(new VpAdapter.BackListener() {
            @Override
            public void onFinish() {
                finish();
            }
        });

        presenter = getmPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.start(ApiConstants.DECODE);
    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        DeviceBean bean = (DeviceBean) o;
        Log.d(TAG, "onSuccess: "+bean.toString());
        ContainManager.save_str("data",bean.getData());
    }

    private ArrayList<Integer> getPageList() {
        imgs = new ArrayList<>();
        imgs.add(R.layout.page1);
        imgs.add(R.layout.page2);
        imgs.add(R.layout.page3);
        return imgs;
    }

    @Override
    protected void click(View view) {

    }


}