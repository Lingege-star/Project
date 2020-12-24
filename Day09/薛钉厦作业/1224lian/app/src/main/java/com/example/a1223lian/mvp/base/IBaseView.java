package com.example.a1223lian.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}