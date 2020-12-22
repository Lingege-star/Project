package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.base
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public abstract class BaseFragment<P extends BasePersenter, T> extends Fragment implements IBaseView {
    private View view;
    private Unbinder bind;
    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (getlayout() != 0) {
            view = inflater.inflate(getlayout(), container, false);
        }
        bind = ButterKnife.bind(this, view);
        mPresenter = createPresenter();
        if (mPresenter!=null){
            mPresenter.attachview(this);
        }
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    protected abstract int getlayout();

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind != null) {
            bind.unbind();
        }
        if (mPresenter!=null){
            mPresenter.unattachview();
            mPresenter=null;
        }
    }
}
