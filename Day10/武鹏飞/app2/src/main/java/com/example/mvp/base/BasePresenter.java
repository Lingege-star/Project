package com.example.mvp.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/*
java里面，四种应用：强引用：无论内存充足或不足时，都不会回收。例如：private int a;
                   软引用：内存足时不回收，内存不足强制回收
                   弱引用：不管内存足不足够，gc碰到时可能回收
                   虚引用：形同虚设，随时都可以回收
 */

//P层的基类：链接M层和V层，处理业务逻辑
//Rxjava的添加和断开网络请求开关disposable
//使用构造方法或者泛型连接P层和V层
// <V extends IBaseView<T>,T>代表V层的实现类，泛型中可以继承
public class BasePresenter <V extends IBaseView<T>,T> implements IPresenter<T>{
    //Weak弱  Reference参考
   protected WeakReference<V> mView;//弱引用，方便回收
    //protected 仅限子类能够访问到

    //网络开关Disposable的容器,不止一个P层，有多个网络请求
    protected CompositeDisposable mComposite = new CompositeDisposable();

    //添加网络开关，RxJava中的方法
    protected void addDisposable(Disposable disposable){
        if (mComposite!=null){
            mComposite.add(disposable);//往容器中添加网络开关
        }
    }



    //用弱引用修饰V层，方便GC回收，不会造成内存泄漏
    //实例化V层，P层关联V层
    protected  void attachView(V view){//fragment绑定视图的方法
        mView = new WeakReference<V>(view);
    }

    //释放V层资源
    //让P层断开网络请求开关
    protected  void detachView(){//fragment解绑的方法
        //TODO 释放资源
        if (mView!=null){
            mView.clear();
            mView = null;
        }
        //TODO 断开网络请求开关
        deleteDisposition();
    }
    //关闭网络请求开关
    private void deleteDisposition() {
        //网络开关容器不为null且没有断开
        if (mComposite!=null&&!mComposite.isDisposed()){
            mComposite.dispose();//断开网络请求
            mComposite.clear();//容器清除
            mComposite = null;
        }
    }

    //重写继承接口的方法
    @Override//没有采参数
    public void start() {
       //ToDo 处理业务逻辑
    }

    @Override//有参数或多个参数，任意类型
    public void start(T... t) {
        //TODO 处理业务逻辑
    }
}
