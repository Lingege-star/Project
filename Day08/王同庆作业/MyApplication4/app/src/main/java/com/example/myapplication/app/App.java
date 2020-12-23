package com.example.myapplication.app;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

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
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
       // MultiDex.install(this);
    }

    public static Context context() {
        return context;
    }
    public static  String getStr(int p){
        return App.context().getString(p);
    }
}
