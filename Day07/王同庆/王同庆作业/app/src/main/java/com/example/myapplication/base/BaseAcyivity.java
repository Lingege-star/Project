package com.example.myapplication.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.mannager.ContionMannager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public abstract class BaseAcyivity<P extends BasePersenter> extends AppCompatActivity implements IBaseView {

    private Unbinder bind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayout() != 0) {
            setContentView(getLayout());
        }
        bind = ButterKnife.bind(this);
        ContionMannager.getMannager().addactivity(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachview(this);
        }
        init();
        initData();
    }


    protected abstract int getLayout();

    protected abstract void OnClick(View view);

    protected abstract P createPresenter();

    protected abstract void init();

    protected abstract void initData();

    public P getmPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.unattachview();
            mPresenter=null;
        }
    }
}
