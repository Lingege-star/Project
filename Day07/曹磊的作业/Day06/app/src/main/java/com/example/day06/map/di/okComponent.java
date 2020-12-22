package com.example.day06.map.di;

import com.example.day06.map.model.RxOpretorlmpl;

import javax.inject.Singleton;

import dagger.Component;
//注射器
@Singleton
@Component(modules = OKManager.class)
public interface okComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorlmpl impl);
}
