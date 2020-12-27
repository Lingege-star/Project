package com.example.day09.map.collback;

public interface CollBack<T> {
    void onSuccessData(T t);
    void  onErrorMsg(String msg);
}
