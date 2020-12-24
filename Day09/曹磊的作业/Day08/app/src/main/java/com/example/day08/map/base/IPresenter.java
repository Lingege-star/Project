package com.example.day08.map.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
