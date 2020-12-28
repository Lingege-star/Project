package com.example.mvp.base;

public interface IPresenter<T> {
    //P层的star方法共有，有些需要传参数，有些不需要串参数，方法重载
    void start();
    void start(T...t);//刷新加载时需要传递页码，。。。代表可变参数，至少1个
}
