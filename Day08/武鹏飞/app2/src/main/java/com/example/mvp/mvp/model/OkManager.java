package com.example.mvp.mvp.model;

import com.example.mvp.mvp.model.api.ApiService;
import com.example.mvp.mvp.model.constants.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

//向外界提供对象、依赖
@Module//向外界提供对象的注解
public class OkManager {
    //提供访问网络的方法OkHttpClient、Retrofit.Builder

    //创建OkHttpClient.Builder对象
    @Singleton//提供的对象为单例 Singleton单独的
    @Provides//提供时添加的注解  Provides提供
    public OkHttpClient.Builder proBuilder(){
        return new OkHttpClient.Builder();
    }
    //创建OkHttpClient.Builder.build()的对象，OkHttpClient.Builder对象从proBuilder中获取
    @Singleton
    @Provides
    public OkHttpClient proOkHttpClient(){
        return proBuilder().build();
    }
    //创建Retrofit.Builder对象
    @Singleton
    @Provides
    public Retrofit.Builder proRetroBuilder(){
        return new Retrofit.Builder();
    }
    //创建Retrofit.Builder.build()对象
    @Singleton
    @Provides
    public Retrofit proRetrofit(){
        return proRetroBuilder()//Retrofit.Builder对象，从之前创建的方法中获取
                .baseUrl(ApiConstants.DEBUG_BASE_URL)//ApiConstants中存放的网络接口
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    //获取ApiService对象，网络请求的注解，Retrofit请求方式
    @Singleton//代表单例
    @Provides
    public ApiService proApiService(){
        return proRetrofit().create(ApiService.class);
    }
}
