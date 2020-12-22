package com.example.mvp2.base.mvp;

public interface IBasePresenter<T> {
    void start();
    void start(T... t);
}
