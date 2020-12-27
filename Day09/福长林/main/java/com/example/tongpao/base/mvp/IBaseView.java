package com.example.tongpao.base.mvp;

public interface IBaseView<T>{

    void onScuccess(T t);
    void onError(String msg);

}
