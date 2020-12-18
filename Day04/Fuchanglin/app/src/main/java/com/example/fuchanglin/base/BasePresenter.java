package com.example.fuchanglin.base;

import com.example.fuchanglin.interfac.IBasePresenter;
import com.example.fuchanglin.interfac.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView>  implements IBasePresenter<V> {
    protected V mView;
    WeakReference<V> weakReference;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unAttachView() {
        mView = null;
    }
}
