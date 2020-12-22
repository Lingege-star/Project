package com.example.myapplication.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.app
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    public static Context context() {
        return context;
    }
    public static  String getStr(int p){
        return App.context().getString(p);
    }
}
