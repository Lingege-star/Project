package com.example.a1222zuo.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>, T> implements IPresenter<T> {
    protected WeakReference<V> mView;
    private CompositeDisposable mComposite =
            new CompositeDisposable();



    protected void addDisposable(Disposable disposable) {
        if (mComposite != null)
            mComposite.add(disposable);
    }



    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }


    protected void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }

    private void deleteDisposable() {
        if (mComposite != null && !mComposite.isDisposed()) {
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }


    @Override
    public void start() {
        //TODO 处理业务逻辑

    }

    @Override
    public void start(T... t) {
        //TODO 处理业务逻辑

    }
}