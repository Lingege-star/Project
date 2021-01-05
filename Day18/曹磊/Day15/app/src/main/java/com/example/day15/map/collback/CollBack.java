package com.example.day15.map.collback;

import io.reactivex.disposables.Disposable;

public interface CollBack<T> {
    void onSuccessData(T t);
    void  onErrorMsg(String msg);
    void onSubscribe(Disposable disposable);
}
