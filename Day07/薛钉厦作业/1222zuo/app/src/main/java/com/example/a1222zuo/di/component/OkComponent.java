package com.example.a1222zuo.di.component;
import com.example.a1222zuo.mvp.model.OkManager;
import com.example.a1222zuo.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OkManager.class)
public interface OkComponent {
    void getSingleApiService(RxOpretorImpl impl);
}