package com.example.day15.map.model;


import com.example.day15.map.collback.CollBack;
import com.example.day15.map.di.DaggerokComponent;
import com.example.day15.map.model.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;



public class RxOpretorlmpl {
    @Inject
    ApiService mApiService;
    public RxOpretorlmpl(){
        DaggerokComponent.create()
                .getSingleApiService(this);
    }

    //没有参数也没有请求头的get请求
    public <T> void rxGetRequest(String url, CollBack<T> collBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(new RxObserver(collBack));
    }

    //有参数没有请求头的get请求
    public <T> void rxGetRequest(String url, Map<String,T>params, CollBack<T> collBack){
        if (params != null && params.size() > 0) { //有参数的请求
            RxOperator.threadtransformer(mApiService.requestGetData(url, params)).
                    subscribe(new RxObserver(collBack));
        } else {  //没有参数的请求
            rxGetRequest(url,collBack);
        }
    }

    //有请求头但是没有参数的get请求
    public <T> void rxGetRequest(String url, HashMap<String, T> headers,
                                 CollBack<T> collBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers)).
                    subscribe(new RxObserver(collBack));
        } else {
            rxGetRequest(url,collBack);
        }
    }

    //没有参数也没有请求头的post请求
    public <T> void rxPostRequest(String url, CollBack<T> collBack) {
        RxOperator.threadtransformer(mApiService.requestPostData(url)).
                subscribe(new RxObserver(collBack));
    }
}
