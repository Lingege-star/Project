package com.example.day09.map.model;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 用来封装各种操作符
 */
public class RxOperator {
    //封装了线程切换
    public static ObservableSource threadtransformer(Observable observable){
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
