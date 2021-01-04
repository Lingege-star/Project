package com.example.day15.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.day15.R;
import com.example.day15.map.Manager.ThreadPoolManager;
import com.example.day15.map.base.App;
import com.example.day15.map.base.BaseActivity;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.model.constants.ApiConstants;
import com.example.day15.presenter.SelCourseActPresenter;

import java.util.concurrent.TimeUnit;

public class SelCourseActivity extends BaseActivity {


    @Override
    protected BasePresenter createPresenter() {
        return new SelCourseActPresenter(this);
    }

    @Override
    protected void init() {
        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
                .executeTimerTask(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(App.context(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },2, TimeUnit.SECONDS);
        getmPresenter().start(ApiConstants.DEVICE);
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
        return 0;
    }
}