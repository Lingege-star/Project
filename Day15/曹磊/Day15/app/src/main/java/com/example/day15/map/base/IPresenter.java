package com.example.day15.map.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
