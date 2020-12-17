package com.example.lianxi3.view;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi2.view
 * 创建者: WangTQ
 * 创建时间: 2020/12/16
 */
public interface CallBack<T> {
    void OnSuecss(T t);
    void OnFaile(String msg);

}
