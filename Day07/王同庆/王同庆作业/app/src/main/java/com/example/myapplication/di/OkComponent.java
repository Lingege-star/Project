package com.example.myapplication.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.di
 * 创建者: WangTQ
 * 创建时间: 2020/12/22
 */


//注射器
@Singleton
@Component(modules = OkManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiServer(RxOpretorImpl impl);
}
