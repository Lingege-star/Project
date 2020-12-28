package com.example.mvp.base;

import java.util.concurrent.TimeUnit;

//线程池的抽象类
public abstract class BaseThreadPool {
    public void executeTask(Runnable runnable) {

    }

    public void executeTimerTask(Runnable runnable, long firstStartTime, long intervalTime,
                                 TimeUnit timeUnit) {
    }

    public void executeTimerTask(Runnable runnable, long delayTime
            ,TimeUnit timeUnit) {
    }

    public abstract void removeTask();

    public void removeTask(Runnable runnable) {

    }

}
