package com.example.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.manager.ContainManager;
import com.example.myapplication.R;
import com.example.myapplication.StatusBarUtil;
import com.example.myapplication.adapter.SelCourseAdapter;
import com.example.myapplication.bean.CourseSubBean;
import com.example.myapplication.presenter.SelCoursePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelCourseActivity extends BaseActivity {

    private static final String TAG = "SelCourseActivity";
    @BindView(R.id.sel_course_rec)
    RecyclerView selCourseRec;
    @BindView(R.id.sel_course_btn)
    Button selCourseBtn;
    private BasePresenter basePresenter;
    private SelCourseAdapter mAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return new SelCoursePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sel_course;
    }

    @Override
    protected void init() {
        StatusBarUtil.setStatusBarColor(this,R.color.white);
        basePresenter = getmPresenter();
        selCourseRec.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        if (o instanceof CourseSubBean){
            CourseSubBean courseSubBean = (CourseSubBean) o;
            List<List<CourseSubBean.DataBean>> data = courseSubBean.getData();
            mAdapter = new SelCourseAdapter(data,this);
            selCourseRec.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
        Log.d(TAG, "onFail: "+msg);
    }

    @Override
    protected void initData() {
        super.initData();
        String data = ContainManager.get_str("data");
        basePresenter.start(data);
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}