package com.example.p7_day05.mvp.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter <V extends IBaseView<T>,T>implements IPresenter<T>{
    private WeakReference<V> mView;
    private CompositeDisposable mComposite=new CompositeDisposable();

    protected void addDisposable(Disposable disposable){
        if(mComposite!=null){
            mComposite.add(disposable);
        }
    }

    protected void attachView(V view){
        mView=new WeakReference<V>(view);
    }

    protected void detachView(){
        if(mView!=null){
            mView.clear();
            mView=null;
        }
        deleteDisposable();
    }

    private void deleteDisposable(){
        if(mComposite!=null&&!mComposite.isDisposed()){
            mComposite.dispose();
            mComposite.clear();
            mComposite=null;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
