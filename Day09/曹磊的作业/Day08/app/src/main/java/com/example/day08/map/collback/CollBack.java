package com.example.day08.map.collback;

public interface CollBack<T> {
    void onSuccessData(T t);
    void  onErrorMsg(String msg);
}
