package com.example.day15.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.Manager.ContainManager;
import com.example.day15.map.Manager.ThreadPoolManager;
import com.example.day15.map.base.App;
import com.example.day15.map.base.BaseActivity;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.model.bean.LingBean;
import com.example.day15.map.model.bean.XuanBean;
import com.example.day15.map.model.constants.ApiConstants;
import com.example.day15.presenter.SelCourseActPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelCourseActivity extends BaseActivity {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.but_ok)
    Button butOk;
    private SelCourseAdapter selCourseAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return new SelCourseActPresenter(this);
    }

    @Override
    protected void init() {
//        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
//                .executeTimerTask(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(App.context(), ShowActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                }, 2, TimeUnit.SECONDS);
        getmPresenter().start(ApiConstants.DEVICE);
        getmPresenter().start(ApiConstants.DECODE);
        getmPresenter().start(ApiConstants.SEL_COURSE);
        rlv.setLayoutManager(new LinearLayoutManager(App.context()));
        butOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(App.context(),ShowActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        getmPresenter().start();
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_sel_course;
    }

    @Override
    public void onScuccess(Object o) {
        super.onScuccess(o);

        if(o instanceof XuanBean){
            XuanBean xuanBean= (XuanBean) o;
            List<List<XuanBean.DataBean>> data = xuanBean.getData();

            selCourseAdapter = new SelCourseAdapter(data);
            rlv.setAdapter(selCourseAdapter);
        }

        Log.e("TAG","请求成功");
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
        Log.e("TAG","失败了哇"+msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}