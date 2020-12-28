package com.example.mvp.mvp.model;

import android.util.Log;

import com.example.mvp.R;
import com.example.mvp.base.App;
import com.example.mvp.callback.RxObserverCallBack;
import com.google.gson.JsonParseException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

//封装访问网络后得到的结果的方法
//继承的observer是io.reactivex.Observer
public class RxObserver<T> implements Observer {
    //全局变量调用
    private RxObserverCallBack<T> callBack;
    protected Disposable mDisposable;

    //构造方法，将得到的结果传递出去，使用接口回调
    public RxObserver(RxObserverCallBack<T> callBack){
        this.callBack = callBack;
    }

    @Override//网络请求的开关
    public void onSubscribe(Disposable d) {
        this.mDisposable = d;
    }

    @Override//访问成功
    public void onNext(Object value) {
        //接口调用的方法
        callBack.onSuccessData((T) value);

    }

    @Override//访问失败
    public void onError(Throwable e) {
    //对异常进行分类，收集异常，进行友盟软件统计，对常见异常进行处理
     //开发时不要写中文，程序国际化，将异常保存在res-->values-->string.xml文件中
        if (e instanceof IOException){
            if (callBack != null)
//                Log.d("TAG", "网络链接异常");
            //接口调用的方法，将打印的异常在另一个文件中调用
                callBack.onErrorMsg(App.getStr(R.string.connec_exception));
        } else if (e instanceof JsonParseException) {
//            Log.d("TAG", "json解析异常");
            if (callBack != null)
                callBack.onErrorMsg(App.getStr(R.string.json_parse_exception));
        } else if (e instanceof SSLException) {
//            Log.d("TAG", "ssl证书异常");
            if (callBack != null)
                callBack.onErrorMsg(App.getStr(R.string.ssl_exception));
        }
    }
    //打印异常的方法，在App中写，全局调用
//    private String getString(int p){
//        //通过上下文调用
//        return App.context().getString(p);
//    }

    @Override//访问完成
    public void onComplete() {
        Log.d("TAG", App.getStr(R.string.complete));
    }
}
