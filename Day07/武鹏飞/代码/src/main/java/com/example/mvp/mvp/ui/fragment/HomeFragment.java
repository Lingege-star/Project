package com.example.mvp.mvp.ui.fragment;

import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.mvp.presenter.HomeFrgPresenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.home_frg_tv)
    TextView mHomeFrgTv;

    @Override//得到P层对象
    protected BasePresenter createPresenter() {
        return new HomeFrgPresenter();
    }

    @Override
    protected void init() {

    }

    @Override //重写方法，加载数据
    protected void initData() {
        super.initData();
        //调用P层加载数据的方法
        getmPresenter().start();
    }

    @Override//加载布局
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }
}
