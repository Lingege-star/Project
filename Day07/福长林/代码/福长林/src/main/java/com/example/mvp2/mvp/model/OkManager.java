package com.example.mvp2.mvp.model;

import com.example.mvp2.mvp.model.api.ApiService;
import com.example.mvp2.mvp.model.constans.ApiConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

@Module
public class OkManager {

    @Singleton
    @Provides
    public OkHttpClient.Builder proBuilder() {
        return new OkHttpClient.Builder();
    }
    @Singleton
    @Provides
    public OkHttpClient proOkHttpClient() {
        return proBuilder().build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder proRetroBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public Retrofit proRetrofit() {
        return proRetroBuilder().
                baseUrl(ApiConstants.DEBUG_BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build();
    }


    //获取ApiService对象
    @Singleton  //代表单例
    @Provides
    public ApiService proApiService() {
        return proRetrofit().create(ApiService.class);
    }


}
