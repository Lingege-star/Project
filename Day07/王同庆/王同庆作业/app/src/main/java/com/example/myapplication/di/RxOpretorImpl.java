package com.example.myapplication.di;

import com.example.myapplication.api.Apiserver;
import com.example.myapplication.callback.CallBack;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.di
 * 创建者: WangTQ
 * 创建时间: 2020/12/22
 */

//封装的网络请求操作类
public class RxOpretorImpl {
    @Inject
    Apiserver mapiserver;

    public RxOpretorImpl() {
        DaggerOkComponent.create().
                getSingleApiServer(this);
    }

    public <T> void RxGetRequest(String url, CallBack<T> callBack) {
        RxOperator.threadformer(mapiserver.requestgetData(url)).subscribe(new RxObServer(callBack));

    }

    public <T> void RxGetRequest(String url, HashMap<String, T> map, CallBack<T> callBack) {
        if (map != null && map.size() > 0) {
            RxOperator.threadformer(mapiserver.requestgetData(url, map)).subscribe(new RxObServer(callBack));
        } else {
            RxGetRequest(url, callBack);
        }

    }

    public <T> void RxGetRequest(String url, Map<String, T> headers, CallBack<T> callBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadformer(mapiserver.requestgetData(url, headers)).subscribe(new RxObServer(callBack));
        } else {
            RxGetRequest(url, callBack);
        }

    }

    public <T> void RxGetRequest(String url, HashMap<String, T> map, Map<String, T> headers, CallBack<T> callBack) {
        if (headers != null && headers.size() > 0 && map != null && map.size() > 0) {
            RxOperator.threadformer(mapiserver.requestgetData(url, headers, map)).subscribe(new RxObServer(callBack));
        } else if (map != null && map.size() > 0 && headers == null || headers.size() == 0) {
            RxGetRequest(url, map, callBack);
        } else if (headers != null && headers.size() > 0 && map == null || map.size() == 0) {
            RxGetRequest(url, headers, callBack);
        } else {
            RxGetRequest(url, callBack);
        }

    }

    //没有参数也没有请求头的post请求
    public <T> void rxPostRequest(String url, CallBack<T> callBack) {
        RxOperator.threadformer(mapiserver.requestPostData(url)).
                subscribe(new RxObServer(callBack));
    }
}
