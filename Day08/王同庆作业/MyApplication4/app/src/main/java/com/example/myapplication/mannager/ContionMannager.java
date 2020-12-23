package com.example.myapplication.mannager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


import com.example.myapplication.app.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.mannager
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class ContionMannager {

    private volatile static ContionMannager mannager;
    private Map<String, Object> mMap;
    private  Set<Activity> set;
    private  SharedPreferences msp;

    public static synchronized ContionMannager getMannager() {
        if (mannager == null) {
            synchronized (ContionMannager.class) {
                if (mannager == null) {
                    mannager = new ContionMannager();
                }
            }
        }
        return mannager;
    }

    public ContionMannager() {
        if (mMap == null) {
            mMap = new HashMap<>();
        }
        if (set == null) {
            set = new HashSet<>();
        }
        if (msp == null) {
            msp = App.context().getSharedPreferences("123",App.MODE_PRIVATE);
        }
    }


    public void putObj(String key, Object obj) {
        mMap.put(key, obj);
    }

    private Object getobj(String key) {
        Object object = mMap.get(key);
        return object;
    }


    public  void save_str(String key, String values) {
        msp.edit().putString(key, values).commit();

    }

    public  String getstr(String key) {
        return msp.getString(key, "");
    }

    public  void save_boolean(String key, Boolean values) {
        msp.edit().putBoolean(key, values).commit();

    }

    public  Boolean getboolean(String key) {
        return msp.getBoolean(key, false);
    }


    public  void addactivity(Activity activity) {
        set.add(activity);
    }

    public  void clearactivity() {
        for (Activity activity : set) {
            if (activity != null) {
                activity.finish();
                System.exit(0);
            }
        }
    }

}
