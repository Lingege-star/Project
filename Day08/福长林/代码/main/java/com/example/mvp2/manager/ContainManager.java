package com.example.mvp2.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.example.mvp2.base.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainManager {
    private volatile static ContainManager manager;
    private Map<String, Object> mMap;
    private Set<Activity> mSet;
    private SharedPreferences mSp;

    private ContainManager() {
        if (mMap == null) {
            mMap = new HashMap<String, Object>();
        }
        if (mSet == null) {
            mSet = new HashSet<Activity>();
        }
        if (mSp == null) {
            mSp = App.mcontext().getSharedPreferences("config", App.MODE_PRIVATE);
        }
    }

    public void save_str(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public String get_str(String key) {
        return mSp.getString(key, "");
    }

    public void save_boolean(String key, Boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public boolean get_boolean(String key) {
        return mSp.getBoolean(key, false);
    }


    public void addActivity(Activity activity) {
        mSet.add(activity);
    }

    public void clearActivity() {
        for (Activity activity : mSet) {
            if (activity != null) {
                activity.finish();
                System.exit(0);
            }
        }
    }


    public void putObj(String key, Object obj) {
        mMap.put(key, obj);
    }

    public Object getObj(String key) {
        Object object = mMap.get(key);
        return object;
    }

    public synchronized static ContainManager getManager() {
        if (manager == null) {
            synchronized (ContainManager.class) {
                if (manager == null) {
                    manager = new ContainManager();
                }
            }
        }
        return manager;
    }
}
