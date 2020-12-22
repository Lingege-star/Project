package com.example.a1222zuo.mvp.model;




import com.example.a1222zuo.callback.RxObserverCallBack;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxOperator {

    public static Observable threadtransformer(Observable observable) {
        return observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableSource concatMap(Observable<T> registerObservable,
                                          Observable<T> loginObservable, RxObserverCallBack<T> callBack) {
        return threadtransformer(registerObservable).
                doOnNext(obj -> {
                    callBack.onSuccessData((T) obj);
                }).observeOn(Schedulers.io()).
                concatMap(obj -> {
                    return loginObservable;
                });
    }


}