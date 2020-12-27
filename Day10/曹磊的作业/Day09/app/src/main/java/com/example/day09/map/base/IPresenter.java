package com.example.day09.map.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
