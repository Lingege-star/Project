package com.example.day03_test01.net;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
