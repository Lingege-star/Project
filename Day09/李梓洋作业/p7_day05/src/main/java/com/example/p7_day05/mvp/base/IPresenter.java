package com.example.p7_day05.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T...t);
}
