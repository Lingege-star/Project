package com.example.IBase;

/**
 * 项目名:TongPao
 * 包名:com.example.mylibrary.Interfaces
 * 创建者: WangTQ
 * 创建时间: 2020/11/24
 */
public interface IBaseView<T> {
    void onSucess(T t);
    void onfaile(String msg);
}
