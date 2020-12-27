package com.example.day09.map.base;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class App extends Application {
    //全局的Context  整个程序都可以用
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        SDKInitializer.initialize(App.context());
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    private void init() {
        mContext=this;
    }
    public static Context context(){
        return mContext;
    }
    public static String getStr(int p){
        return App.mContext.getString(p);
    }
}
