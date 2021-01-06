package com.example.myapplication.fragment;

import android.util.Log;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.manager.ContainManager;
import com.example.myapplication.R;
import com.example.myapplication.StatusBarUtil;
import com.example.myapplication.activity.SelCourseActivity;
import com.example.myapplication.adapter.SelCourseAdapter;
import com.example.myapplication.bean.CourseSubBean;
import com.example.myapplication.presenter.SelCoursePresenter;

import java.util.List;

import butterknife.BindView;

public class CourseFragment extends BaseFragment {

    private static final String TAG = "CourseFragment";
    @BindView(R.id.course_rec)
    RecyclerView courseRec;
    @BindView(R.id.course_btn)
    Button courseBtn;
    private BasePresenter basePresenter;
    private SelCourseAdapter mAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return new SelCoursePresenter(this);
    }

    @Override
    protected void init() {
        StatusBarUtil.setStatusBarColor(getActivity(), R.color.white);
        basePresenter = getmPresenter();
        courseRec.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void initData() {
        super.initData();
        String data = ContainManager.get_str("data");
        basePresenter.start(data);
    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        if (o instanceof CourseSubBean){
            CourseSubBean courseSubBean = (CourseSubBean) o;
            List<List<CourseSubBean.DataBean>> data = courseSubBean.getData();
            mAdapter = new SelCourseAdapter(data,getContext());
            courseRec.setAdapter(mAdapter);
        }
    }

    @Override
    public void onFail(String msg) {
        super.onFail(msg);
        Log.d(TAG, "onFail: "+msg);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course;
    }
}
