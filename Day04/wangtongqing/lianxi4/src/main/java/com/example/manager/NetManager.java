package com.example.manager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.manager
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class NetManager {

    public static Retrofit getRetrofit(String url) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }
}
