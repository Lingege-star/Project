package com.example.mvp.di.component;

import com.example.mvp.mvp.model.OkManager;
import com.example.mvp.mvp.model.RxOpretorImp1;

import javax.inject.Singleton;

import dagger.Component;

//注入对象的方法
@Singleton//单例
//注射器
@Component(modules = OkManager.class)
public interface OKComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImp1 imp1);//参数是要注入的类
}
