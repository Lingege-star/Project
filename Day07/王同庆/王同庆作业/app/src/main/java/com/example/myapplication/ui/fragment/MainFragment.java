package com.example.myapplication.ui.fragment;

import androidx.fragment.app.Fragment;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.base.IBaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements IBaseView {

    @Override
    protected int getlayout() {
        return 0;
    }

    @Override
    protected BasePersenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void OnSucess(Object o) {

    }

    @Override
    public void OnFile(String msg) {

    }
}
