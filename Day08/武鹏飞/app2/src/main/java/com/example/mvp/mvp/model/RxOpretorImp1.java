package com.example.mvp.mvp.model;

import com.example.mvp.callback.RxObserverCallBack;
import com.example.mvp.di.component.DaggerOKComponent;
import com.example.mvp.mvp.model.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

//网络请求框架封装
public class RxOpretorImp1 {
    @Inject//需求方的注解
    ApiService mApiService;
    //构造方法,得到编译到DaggerOKComponent类，没有的话点小锤子图标，编译之后生成在build文件夹中
    //Dagger短剑、Component组成
    public RxOpretorImp1(){
        //编译生成的类调用注射器中自定义的方法
        DaggerOKComponent
                .create().getSingleApiService(this);
        //或者
//        .builder().build().getSingleApiService(this);

    }
    //没有参数也没有请求头的get请求
    //封装一个get请求的方法，无参数，可以将ApiService中所有的请求方式封装
    public <T> void RxGetRequest(String url, RxObserverCallBack<T> callBack) {
        //调用ApiService类中的请求方式访问网络，请求的过程可以封装成一个类
        //封装前
//        mApiService.requestGetData(url).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ResponseBody>() {
                        //对访问网络的结果进行封装
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//                    @Override
//                    public void onComplete() {
//                    }
//                });
        //封装后                       observable对象
        RxOperator.threadTransformer(mApiService.requestGetData(url)).
                //调用访问网络结果的方法，需要回调的接口，方法中添加接口参数
                subscribe(new RxObserver(callBack));
    }

    //有参数没有请求头的get请求
    //封装一个get请求的方法，有参数
    public <T> void RxGetRequest(String url, Map<String,T> params,RxObserverCallBack<T> callBack) {
        if (params!=null&&params.size()>0){////有参数的请求
            RxOperator.threadTransformer(mApiService.requestGetData(url,params)).
                    subscribe(new RxObserver(callBack));
        }else {//没有参数的请求
            RxGetRequest(url,callBack);
        }
    }

    //有请求头但是没有参数的get请求
    public <T> void RxGetRequest(String url, HashMap<String,T> headers, RxObserverCallBack<T> callBack) {
        if (headers!=null&&headers.size()>0){////有参数的请求
            RxOperator.threadTransformer(mApiService.requestGetData(url,headers)).
                    subscribe(new RxObserver(callBack));
        }else {//没有参数的请求
            RxGetRequest(url,callBack);
        }
    }

    //既有请求头也有请求参数的get请求
    public <T> void RxGetRequest(String url, HashMap<String, T> headers,
                                 Map<String, T> params, RxObserverCallBack<T> callBack) {
        //既有请求头也有请求参数的get请求
        if (headers != null && headers.size() > 0 && params != null && params.size() > 0) {
            RxOperator.threadTransformer(mApiService.requestGetData(url, headers, params)).
                    subscribe(new RxObserver(callBack));
            //只有请求头没有请求参数的get请求
        } else if (headers != null && headers.size() > 0 && (params == null || params.size() == 0)) {
            RxGetRequest(url, headers, callBack);
            //只有参数但是没有请求头的get请求
        } else if (params != null && params.size() > 0 && (headers == null || headers.size() == 0)) {
            RxGetRequest(url, params, callBack);
        } else {
            //既没有请求头也没有请求参数的get请求
            RxGetRequest(url, callBack);
        }
    }

    //没有参数也没有请求头的post请求
    public <T> void RxPostRequest(String url,RxObserverCallBack<T> callBack) {
            RxOperator.threadTransformer(mApiService.requestGetData(url)).
                    subscribe(new RxObserver(callBack));

    }
}
