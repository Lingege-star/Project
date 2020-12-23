package com.example.p7_day05.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
