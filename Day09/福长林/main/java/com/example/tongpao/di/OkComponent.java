package com.example.tongpao.di;


import com.example.tongpao.mvp.OkManager;
import com.example.tongpao.mvp.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = OkManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}
