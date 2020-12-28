package com.example.mvp.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {
//public class App<T> extends Application {

    //程序运行时清单文件从上执行到下，首先运行App类，里面的东西不能太多，否则App启动加载会变慢

//全局的Context  整个程序都可以用
private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    //共用的上下文
    private void init() {
        mContext = this;
    }
    //外界调用上下文的方法
    public static Context context() {
        return mContext;
    }
    //将int常量转换成代表的字符串内容
    public static String getStr(int p){
        return App.context().getString(p);
    }

}
