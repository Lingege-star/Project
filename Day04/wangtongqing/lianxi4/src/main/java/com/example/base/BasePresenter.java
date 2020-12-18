package com.example.base;

import com.example.IBase.IBasePresenter;
import com.example.IBase.IBaseView;

import java.lang.ref.WeakReference;

/**
 * 项目名:TongPao
 * 包名:com.example.mylibrary.Base
 * 创建者: WangTQ
 * 创建时间: 2020/11/24
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    protected V mview;
    WeakReference<V>weakReferenceview;

    @Override
    public void attachview(V view) {
        weakReferenceview=new WeakReference<V>(view);
        mview=weakReferenceview.get();
    }

    @Override
    public void unattachview() {
        mview=null;
    }
}
