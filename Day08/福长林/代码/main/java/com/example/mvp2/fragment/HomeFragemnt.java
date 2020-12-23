package com.example.mvp2.fragment;

import android.util.Log;
import android.widget.TextView;

import com.example.mvp2.R;
import com.example.mvp2.base.fragment.BaseFragment;
import com.example.mvp2.base.mvp.BasePresenter;
import com.example.mvp2.mvp.presenter.HomeFrgPresenter;

import butterknife.BindView;

public class HomeFragemnt extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new HomeFrgPresenter(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initData() {
        getmPresenter().start();
    }
    @Override
    public void onScuccess(Object obj) {
        String str = (String) obj;
        Log.e("TAG", str+"================");
    }


    @Override
    public void onError(String msg) {
        Log.e("TAG", msg+"================");
    }
}
