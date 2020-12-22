package com.example.mvp.callback;

//网络访问后的回调的接口
public interface RxObserverCallBack<T> {
    //请求网络成功的方法
    void onSuccessData(T t);
    //请求网络失败的方法
    void onErrorMsg(String msg);
}
