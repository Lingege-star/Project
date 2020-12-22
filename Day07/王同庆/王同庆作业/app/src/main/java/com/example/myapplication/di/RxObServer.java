package com.example.myapplication.di;

import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.app.App;
import com.example.myapplication.callback.CallBack;
import com.google.gson.JsonParseException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.di
 * 创建者: WangTQ
 * 创建时间: 2020/12/22
 */
public class RxObServer<T>  implements Observer {
    private  static  final  String TAG="RxObServer";
    private CallBack<T> callBack;
    private Disposable disposable;

    public RxObServer(CallBack<T> callBack) {
        this.callBack = callBack;
    }
    @Override
    public void onSubscribe(Disposable d) {
        this.disposable=d;
    }

    @Override
    public void onNext(Object o) {
        if (callBack!=null){
            callBack.OnOk((T) o);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof IOException) {
            if (callBack != null)
                callBack.OnNo(App.getStr(R.string.connec_exception));
        } else if (e instanceof JsonParseException) {
            if (callBack != null)
                callBack.OnNo(App.getStr(R.string.json_parse_exception));
        } else if (e instanceof SSLException) {
            if (callBack != null)
                callBack.OnNo(App.getStr(R.string.ssl_exception));
        }
    }

    @Override
    public void onComplete() {
        Log.e("TAG", "onComplete: "+ App.getStr(R.string.complete));
    }
}
