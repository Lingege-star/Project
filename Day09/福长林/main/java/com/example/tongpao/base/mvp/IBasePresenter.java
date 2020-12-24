package com.example.tongpao.base.mvp;

public interface IBasePresenter<T> {
    void start();
    void start(T... t);
}
