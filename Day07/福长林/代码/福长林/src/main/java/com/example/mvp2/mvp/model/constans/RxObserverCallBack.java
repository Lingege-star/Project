package com.example.mvp2.mvp.model.constans;

public interface RxObserverCallBack<T> {

    void onSuccessData(T t);

    void onErrorMsg(String msg);


}
