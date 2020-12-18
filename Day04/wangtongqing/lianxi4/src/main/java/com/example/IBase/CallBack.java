package com.example.IBase;

/**
 * 项目名:TongPao
 * 包名:com.example.mylibrary.Interfaces
 * 创建者: WangTQ
 * 创建时间: 2020/11/24
 */
public interface CallBack<T> {
    void OnSucess(T t);
    void faile(String msg);
}
