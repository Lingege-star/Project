package com.example.mvp2.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context = this;
    }
    public static Context mcontext(){
        return context;
    }
    public static String getStr(int p) {
        return App.context.getString(p);
    }
}
