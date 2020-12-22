package com.example.myapplication.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.base
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class BasePersenter<V extends IBaseView<V>, T> implements IBasePersenter<T> {
    private WeakReference<V> mview;
    private CompositeDisposable composite =new CompositeDisposable();

    protected void  addDisposable(Disposable disposable){
        if (composite!=null){
            composite.add(disposable);
        }
    }
    protected void attachview(V view) {
        mview=new WeakReference<V>(view);
    }

    protected void unattachview() {
        if (mview != null) {
            mview.clear();
            mview = null;
        }
        deleteDisposable();
    }

    private void deleteDisposable() {
            if (composite!=null&&composite.isDisposed()){
                composite.dispose();
                composite.clear();
                composite=null;
            }
    }


    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
