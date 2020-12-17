package com.example.zuo_03;

import android.app.Application;

import com.example.zuo_03.db.DaoMaster;
import com.example.zuo_03.db.DaoSession;

public class App extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper student = new DaoMaster.DevOpenHelper(this, "student");
        daoSession = new DaoMaster(student.getReadableDb()).newSession();
    }
}
