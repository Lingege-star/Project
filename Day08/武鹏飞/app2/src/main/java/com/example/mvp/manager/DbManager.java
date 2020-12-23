package com.example.mvp.manager;

//数据库管理器
public class DbManager {
    //饿汉式单例
    private  volatile static DbManager mManager;

    private DbManager(){

    }
    public static synchronized DbManager getmManager(){
        if (mManager==null){
            synchronized (DbManager.class){
                if (mManager==null){
                    mManager = new DbManager();
                }
            }
        }
        return mManager;
    }
}
