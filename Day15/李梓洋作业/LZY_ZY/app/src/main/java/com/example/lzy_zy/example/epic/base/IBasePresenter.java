package com.example.lzy_zy.example.epic.base;

public interface IBasePresenter<T> {

    void start();
    void start(T... t);

}
