package com.example.mvp2.base.mvp;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
