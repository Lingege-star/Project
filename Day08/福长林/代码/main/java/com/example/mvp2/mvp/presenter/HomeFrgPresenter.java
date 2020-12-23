package com.example.mvp2.mvp.presenter;

import com.example.mvp2.base.mvp.BasePresenter;
import com.example.mvp2.fragment.HomeFragemnt;
import com.example.mvp2.mvp.model.RxOpretorImpl;
import com.example.mvp2.mvp.model.constans.ApiConstants;
import com.example.mvp2.mvp.model.constans.RxObserverCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;

public class HomeFrgPresenter extends BasePresenter {
    private RxOpretorImpl mImpl;
    private HomeFragemnt mHomeFragemnt;
    public HomeFrgPresenter(HomeFragemnt homeFragemnt){
        mImpl = new RxOpretorImpl();
        this.mHomeFragemnt = homeFragemnt;
    }

    @Override
    public void start() {
        mImpl.rxGetRequest(ApiConstants.BAIDU_LIST, new RxObserverCallBack<Object>() {
            @Override
            public void onSuccessData(Object obj) {
                if (mHomeFragemnt != null){
                    ResponseBody responseBody = (ResponseBody) obj;
                    try {
                        String string = responseBody.string();
                        mHomeFragemnt.onScuccess(string);
                    } catch (IOException e) {
                        e.printStackTrace();
                        mHomeFragemnt.onError(e.getMessage());
                    }

                }
            }

            @Override
            public void onErrorMsg(String msg) {
                if (mHomeFragemnt != null) {
                    mHomeFragemnt.onError(msg);
                }
            }
        });
    }


}