package com.example.day15.map.base;

public interface IBaseView<T> {
    //成功
    void onScuccess(T t);

    //失败
    void onError(String msg);

}
