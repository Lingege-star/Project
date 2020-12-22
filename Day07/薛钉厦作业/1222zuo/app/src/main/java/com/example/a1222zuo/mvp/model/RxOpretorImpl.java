package com.example.a1222zuo.mvp.model;


import com.example.a1222zuo.callback.RxObserverCallBack;
import com.example.a1222zuo.di.component.DaggerOkComponent;
import com.example.a1222zuo.mvp.model.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;



public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {
       DaggerOkComponent.create().
                getSingleApiService(this);
    }


    public <T> void rxGetRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(new RxObserver(callBack));
    }



    public <T> void rxGetRequest(String url, Map<String, T> params,
                                 RxObserverCallBack<T> callBack) {
        if (params != null && params.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, params)).
                    subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }


    public <T> void rxGetRequest(String url, HashMap<String, T> headers,
                                 RxObserverCallBack<T> callBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers)).
                    subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }



    public <T> void rxGetRequest(String url, HashMap<String, T> headers,
                                 Map<String, T> params, RxObserverCallBack<T> callBack) {

        if (headers != null && headers.size() > 0 && params != null && params.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers, params)).
                    subscribe(new RxObserver(callBack));

        } else if (headers != null && headers.size() > 0 && (params == null || params.size() == 0)) {
            rxGetRequest(url, headers, callBack);

        } else if (params != null && params.size() > 0 && (headers == null || headers.size() == 0)) {
            rxGetRequest(url, params, callBack);
        } else {

            rxGetRequest(url, callBack);
        }
    }

    public <T> void rxPostRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestPostData(url)).
                subscribe(new RxObserver(callBack));
    }
}