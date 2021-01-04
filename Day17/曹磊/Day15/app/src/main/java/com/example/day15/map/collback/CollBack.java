package com.example.day15.map.collback;

public interface CollBack<T> {
    void onSuccessData(T t);
    void  onErrorMsg(String msg);
}
