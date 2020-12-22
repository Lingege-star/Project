package com.example.mvp2.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp2.base.mvp.BasePresenter;
import com.example.mvp2.base.mvp.IBaseView;
import com.example.mvp2.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T> {


    private Unbinder bind;
    private P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutid = getlayoutid();
        if(layoutid!=0){
            setContentView(layoutid);
        }
        bind = ButterKnife.bind(this);
        ContainManager.getManager().addActivity(this);
        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        init();
        initData();

    }

    private void initData() {

    }

    protected abstract void init();

    protected abstract P createPresenter();

    protected abstract int getlayoutid();

    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
