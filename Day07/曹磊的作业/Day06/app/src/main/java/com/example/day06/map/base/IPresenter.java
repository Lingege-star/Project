package com.example.day06.map.base;

public interface IPresenter<T> {
    void start();
    void start(T...t);
}
