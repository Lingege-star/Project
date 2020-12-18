package com.example.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.IBase.IBaseView;


/**
 * 项目名:TongPao
 * 包名:com.example.mylibrary.Base
 * 创建者: WangTQ
 * 创建时间: 2020/11/24
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    protected P pPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pPresenter = createPresenter();
        if (pPresenter != null) {
            pPresenter.attachview(this);
        }
        initView();
        initData();
    }


    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P createPresenter();

    @Override
    public void onSucess(Object o) {

    }

    @Override
    public void onfaile(String msg) {
        Log.e("TAG", "onfaile: " +msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (pPresenter != null) {
            pPresenter.unattachview();
        }

    }
}
