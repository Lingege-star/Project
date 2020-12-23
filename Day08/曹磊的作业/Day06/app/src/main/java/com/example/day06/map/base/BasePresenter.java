package com.example.day06.map.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
//1.链接M层和 V层     2.处理业务逻辑    3.添加和断开网络请求开关
public class BasePresenter<V extends IBaseView<T>,T>implements IPresenter<T> {
private WeakReference<V> mView;
private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //添加网络请求
    protected void addPosable(Disposable disposable){
        if(compositeDisposable!=null){
            compositeDisposable.add(disposable);
        }
    }
    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
protected void attachView(V view){
    mView=new WeakReference<V>(view);
}

    //2.释放资源  2.让P层断开网络请求
    protected void detachView(){
    //释放资源
        if(mView!=null){
            mView.clear();
            mView=null;
        }
        //断开网络请求
        delectPosable();
    }

    private void delectPosable() {
        if(compositeDisposable!=null&&compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable.clear();
            compositeDisposable=null;
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
