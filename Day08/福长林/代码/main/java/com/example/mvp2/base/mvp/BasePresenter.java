package com.example.mvp2.base.mvp;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IBaseView, T> implements IBasePresenter<T> {
    private WeakReference<V> mWeak;
    private CompositeDisposable mCompos = new CompositeDisposable();

    protected void addDisposable(Disposable disposable){
        if (mCompos != null)
            mCompos.add(disposable);
    }
    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    public void attachView(V view) {
        mWeak = new WeakReference<V>(view);
    }


    //2.释放V层资源的同时断开网络开关
    public void detachView() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
        deleteDisposable();
    }

    //断开网络开关
    private void deleteDisposable() {
        if (mCompos != null && !mCompos.isDisposed()) {
            mCompos.dispose();
            mCompos.clear();
            mCompos = null;
        }
    }
    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
