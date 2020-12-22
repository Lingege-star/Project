package com.example.mvp.mvp.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.callback.RxObserverCallBack;
import com.example.mvp.mvp.model.RxOpretorImp1;
import com.example.mvp.mvp.model.constants.ApiConstants;

public class HomeFrgPresenter extends BasePresenter {

    //加载网络框架的类对象
    private RxOpretorImp1 mImp1;
    public HomeFrgPresenter(){
        mImp1 =  new RxOpretorImp1();
    }

    //重写加载数据的方法
    @Override
    public void start() {
        //通过加载网络框架的对象调用方法
        //网址常量在ApiConstants中设置
        mImp1.RxGetRequest(ApiConstants.RELEASE_BASE_URL, new RxObserverCallBack<Object>() {
            @Override
            public void onSuccessData(Object o) {
                if()
            }

            @Override
            public void onErrorMsg(String msg) {

            }
        });

    }
}
