package com.example.mvp.thread;

import com.example.mvp.base.BaseThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//单个线程池，当前页面使用
public class SingleThreadPool extends BaseThreadPool{

    private static SingleThreadPool mSchduleThreadPool;
    private ExecutorService mExecutorService;

    private SingleThreadPool() {
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    public static synchronized SingleThreadPool getSingleThreadPool() {
        if (mSchduleThreadPool == null) {
            synchronized (SingleThreadPool.class) {
                if (mSchduleThreadPool == null) {
                    mSchduleThreadPool = new SingleThreadPool();
                }
            }
        }
        return mSchduleThreadPool;
    }

    @Override
    public void executeTask(Runnable runnable) {
        super.executeTask(runnable);
        if (mExecutorService != null)
            mExecutorService.execute(runnable);
    }

    @Override
    public void removeTask() {
        mExecutorService.shutdown();
    }
}
