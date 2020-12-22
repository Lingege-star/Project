package com.example.a1222zuo.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}