package com.example.a1223lian.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}