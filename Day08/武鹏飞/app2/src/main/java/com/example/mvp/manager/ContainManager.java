package com.example.mvp.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.mvp.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//容器管理器
public class ContainManager {
    //保证manager对象唯一的关键字 volatile 易变的
    private volatile static ContainManager mManager;
    //用来两个activity或者fragment或者两个类之间传递对象，是一个单例对象
    //泛型是保证数据的安全性，限制数据的类型
    //在内存中开辟一个空间，存map集合
    private static Map<String, Object> mMap;
    //定义一个集合存储所有需要添加到集合的Activity
    //在内存中开辟一个空间，存set集合
    private static Set<Activity> mSet;
    //全局的SP 整个程序都可以用，数据持久化
    private static SharedPreferences mSp;

    //本类私有化
    private ContainManager() {
        //进行非空判断
        if (mMap == null) {
            mMap = new HashMap<String, Object>();
        }
        if (mSet == null) {
            mSet = new HashSet<Activity>();
        }
        if (mSp == null) {
            //可以用来传值，需要上下文
            mSp = App.context().getSharedPreferences("config", App.MODE_PRIVATE);
        }
    }

    //sp中存值
    public void save_str(String key, String value) {
        //封装sp的存值方法
        mSp.edit().putString(key, value).commit();
    }

    //从sp中取值
    public String get_str(String key) {
        return mSp.getString(key, "");
    }

    //sp保存boolean值
    public void save_boolean(String key, boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    //sp获取boolean值
    public boolean get_boolean(String key) {
        return mSp.getBoolean(key, false);
    }

    //往activity集合中添加activity
    public void addActivity(Activity activity) {
        mSet.add(activity);
    }

    //静态方法时可以直接调用这个方法，没有通过上方的ContainManager方法调用，没有添加到集合中，返回为空
//    public static void addActivity(Activity activity) {
//        mSet.add(activity);
//    }

    //关闭程序，清空所有activity
    public void clearActivity() {
        //通过遍历的形式将集合中的每一个activity遍历出来，全部关闭
        for (Activity activity : mSet) {
            if (activity != null) {
                activity.finish();
                //系统的进程关闭
                System.exit(0);
            }
        }
    }
    //往Map中传值
    public static void putObject(String key, Object object) {
        mMap.put(key, object);
    }
    //从Map中获取值
    public Object getObject(String key) {
            Object object = mMap.get(key);
            return object;

    }
    //Map单例外部掉用时直接app.调用，懒汉式
    public static synchronized ContainManager getmManager() {
        if (mManager == null) {
            synchronized (ContainManager.class) {
                if (mManager == null) {
                    mManager = new ContainManager();
                }
            }
        }
        return mManager;
    }
}
