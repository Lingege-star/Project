package com.example.myapplication.base;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.base
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public interface IBaseView<T> {
    void OnSucess(T t);
    void OnFile(String msg);

}
