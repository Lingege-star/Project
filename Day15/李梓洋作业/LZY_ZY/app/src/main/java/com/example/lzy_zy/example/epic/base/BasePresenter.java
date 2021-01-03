package com.example.lzy_zy.example.epic.base;

import android.view.View;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView,T> implements IBasePresenter<T> {

    private WeakReference<V> mView;

    protected void addView(V view){
        mView = new WeakReference<V>(view);
    }


}
