package com.example.p7_day05.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.p7_day05.mvp.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements IBaseView<T> {
    private Unbinder mBind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if(layoutId!=0)
            setContentView(layoutId);
        mBind=ButterKnife.bind(this);
        ContainManager.getmManager().addActivity(this);
        mPresenter=createPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
        init();
        initData();
    }

    protected abstract P createPresenter();

    protected P getmPresenter(){
        if(mPresenter!=null){
            return mPresenter;
        }
        return null;
    }

    protected void initData() {
    }

    protected abstract void init();

    protected abstract int getLayoutId();

    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBind!=null){
            mBind.unbind();
        }
        if(mPresenter!=null){
            mPresenter.detachView();
            mPresenter=null;
        }
    }
}
