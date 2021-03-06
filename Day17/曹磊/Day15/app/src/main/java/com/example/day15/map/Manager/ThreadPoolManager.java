package com.example.day15.map.Manager;


import com.example.day15.map.base.BaseThreadPool;
import com.example.day15.map.thread.CustomThreadPool;
import com.example.day15.map.thread.SchduleThreadPool;
import com.example.day15.map.thread.SingleThreadPool;

public class ThreadPoolManager {
    public static final int CUSTOM_THREADPOOL = 0;
    public static final int SINGLE_THREADPOOL = 1;
    public static final int SCHDULE_THREADPOOL = 2;

    public static BaseThreadPool getThreadPool(int type) {
        switch (type) {
            case CUSTOM_THREADPOOL:
                return CustomThreadPool.getThreadPool();
            case SINGLE_THREADPOOL:
                return SingleThreadPool.getSingleThreaPool();
            case SCHDULE_THREADPOOL:
                return SchduleThreadPool.getmSchduleThreadPool();
        }
        return null;
    }
}
