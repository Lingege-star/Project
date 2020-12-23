package com.example.mvp.thread;

import com.example.mvp.base.BaseThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//定时线程池
public class ScheduleThreadPool extends BaseThreadPool{
    private static ScheduleThreadPool mScheduleThreadPool;
    private ScheduledExecutorService mExecuteService;

    @Override
    public void executeTimerTask(Runnable runnable, long firstStartTime,
                                 long intervalTime, TimeUnit timeUnit) {
        mExecuteService.scheduleWithFixedDelay(runnable, firstStartTime, intervalTime, timeUnit);
    }

    @Override
    public void executeTimerTask(Runnable runnable, long delayTime, TimeUnit timeUnit) {
        mExecuteService.schedule(runnable, delayTime, timeUnit);
    }

    private ScheduleThreadPool() {
        mExecuteService = Executors.newSingleThreadScheduledExecutor();
    }


    public synchronized static ScheduleThreadPool getmScheduleThreadPool() {
        if (mScheduleThreadPool == null) {
            synchronized (ScheduleThreadPool.class) {
                if (mScheduleThreadPool == null) {
                    mScheduleThreadPool = new ScheduleThreadPool();
                }
            }
        }
        return mScheduleThreadPool;
    }

    @Override
    public void removeTask() {

    }
}
