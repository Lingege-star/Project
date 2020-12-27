package com.example.tongpao.mvp;

import com.example.tongpao.di.DaggerOkComponent;
import com.example.tongpao.mvp.model.api.ApiService;
import com.example.tongpao.mvp.model.constans.RxObserverCallBack;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class RxOpretorImpl {
    @Inject
    ApiService mApiService;


    public RxOpretorImpl() {
        DaggerOkComponent.create()
                .getSingleApiService(this);
    }

    public <T> void rxGetRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url))
                .subscribe(new RxObserver(callBack));
    }

    public <T> void rxGetRequest(String url, Map<String, T> parms, RxObserverCallBack<T> callBack) {
        if (parms != null && parms.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, parms))
                    .subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }

    public <T> void rxGetRequest(String url, HashMap<String, T> headers, RxObserverCallBack<T> callBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers))
                    .subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }

    public <T> void rxGetRequest(String url, HashMap<String, T> headers,
                                 Map<String, T> parms, RxObserverCallBack<T> callBack) {
        if (headers!=null&&headers.size()>0 && parms!= null && parms.size()>0){
            RxOperator.threadtransformer(mApiService.requestGetData(url,headers,parms))
                    .subscribe(new RxObserver(callBack));
        }else if (headers!=null&&headers.size()>0  && (parms== null || parms.size()==0)){
            rxGetRequest(url,headers,callBack);
        }else if (parms!= null && parms.size()>0 && (headers==null&&headers.size()==0 )){
            rxGetRequest(url,parms,callBack);
        }else {
            rxGetRequest(url,callBack);
        }
    }
    //没有参数也没有请求头的post请求
    public <T> void rxPostRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestPostData(url)).
                subscribe(new RxObserver(callBack));
    }

}
