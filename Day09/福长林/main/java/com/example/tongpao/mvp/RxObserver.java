package com.example.tongpao.mvp;

import android.util.Log;

import com.example.tongpao.R;
import com.example.tongpao.base.App;
import com.example.tongpao.mvp.model.constans.RxObserverCallBack;

import org.json.JSONException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxObserver<T> implements Observer {
    private static final String TAG = "RxObserver";
    private RxObserverCallBack<T> callBack;
    protected Disposable mDisPosable;
    public RxObserver(RxObserverCallBack<T> callBack) {
        this.callBack = callBack;
    }


    @Override
    public void onSubscribe(Disposable disposable) {
        this.mDisPosable = disposable;
    }

    @Override
    public void onNext(Object o) {
        if (callBack != null){
            callBack.onSuccessData((T) o);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException){
            if (callBack != null)
                callBack.onErrorMsg(App.getStr(R.string.connec_exception));
        }else if (e instanceof JSONException){
            if (callBack != null)
                callBack.onErrorMsg(App.getStr(R.string.json_parse_exception));
        }else if (e instanceof SSLException){
            if (callBack != null)
                callBack.onErrorMsg(App.getStr(R.string.ssl_exception));
        }
    }

    @Override
    public void onComplete() {
        Log.e(TAG, App.getStr(R.string.complete));
    }
}
