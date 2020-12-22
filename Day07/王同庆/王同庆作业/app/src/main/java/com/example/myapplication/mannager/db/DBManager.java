package com.example.myapplication.mannager.db;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.mannager.db
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class DBManager {
    private volatile static  DBManager manager;

    public DBManager() {
    }
    public static synchronized DBManager getManager(){
        if (manager==null){
            synchronized (DBManager.class){
                if (manager==null){
                    manager=new DBManager();
                }
            }
        }
        return manager;
    }
}
