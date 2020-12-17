package com.example.day12_17.MvpInterface;

public interface ResultCallBack<T>{
    void OnSuccess(T t);
    void OnFile(String msg);
}
