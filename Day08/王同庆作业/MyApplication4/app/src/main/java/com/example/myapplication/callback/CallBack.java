package com.example.myapplication.callback;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.callback
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public interface CallBack<T> {
    void OnOk(T t);
    void OnNo(String msg);

}
