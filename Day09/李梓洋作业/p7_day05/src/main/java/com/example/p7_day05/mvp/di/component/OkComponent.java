package com.example.p7_day05.mvp.di.component;

import com.example.p7_day05.mvp.mvp.model.OkManager;
import com.example.p7_day05.mvp.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OkManager.class)
public interface OkComponent {
    void getSingleApiService(RxOpretorImpl impl);
}
