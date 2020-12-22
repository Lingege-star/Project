package com.example.myapplication.di;

import com.example.Constants;
import com.example.myapplication.api.Apiserver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.di
 * 创建者: WangTQ
 * 创建时间: 2020/12/22
 */
@Module
public class OkManager {

    @Provides
    @Singleton
    public OkHttpClient.Builder proBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    public OkHttpClient proOkHttpClient() {
        return proBuilder().build();
    }

    @Provides
    @Singleton
    public Retrofit.Builder proRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    public Retrofit proRetrofit() {
        return proRetrofitBuilder()
                .baseUrl(Constants.RELEASE_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public Apiserver proApiserver() {
        return proRetrofit().create(Apiserver.class);
    }

}
