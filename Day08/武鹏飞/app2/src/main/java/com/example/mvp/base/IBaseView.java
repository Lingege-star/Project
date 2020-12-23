package com.example.mvp.base;
//View层的接口
public interface IBaseView<T> {
    //访问网络成功更新UI的方法
    void onSuccess(T t);
    //访问网络失败的方法
    void onError(String msg);
}
