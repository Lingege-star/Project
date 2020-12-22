package com.example.a1222zuo.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}