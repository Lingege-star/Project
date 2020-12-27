package com.example.day09.map.model;

import android.util.Log;


import com.example.day09.R;
import com.example.day09.map.base.App;
import com.example.day09.map.collback.CollBack;
import com.google.gson.JsonParseException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxObserver<T> implements Observer {
private CollBack<T> collBack;
    public RxObserver(CollBack<T> collBack){
        this.collBack=collBack;
    }
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object value) {
        collBack.onSuccessData((T)value);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException) {
            collBack.onErrorMsg(App.getStr(R.string.connec_exception));
        } else if (e instanceof JsonParseException) {
            collBack.onErrorMsg(App.getStr(R.string.json_parse_exception));
        } else if (e instanceof SSLException) {
            collBack.onErrorMsg(App.getStr(R.string.ssl_exception));
        }
    }

    @Override
    public void onComplete() {
        Log.e("TAG", App.getStr(R.string.complete));
    }
}
