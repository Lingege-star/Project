package com.example.myapplication.di;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.di
 * 创建者: WangTQ
 * 创建时间: 2020/12/22
 */
public class RxOperator {
    //用来封装各种操作符
    public static Observable threadformer(Observable observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
