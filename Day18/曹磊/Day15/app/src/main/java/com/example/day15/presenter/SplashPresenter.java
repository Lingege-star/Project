package com.example.day15.presenter;

import com.example.day15.Util.GsonUtil;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.base.IBaseView;
import com.example.day15.map.collback.CollBack;
import com.example.day15.map.model.RxOpretorlmpl;
import com.example.day15.map.model.bean.LingBean;
import com.example.day15.map.model.constants.ApiConstants;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class SplashPresenter extends BasePresenter {
    private IBaseView mView;
    private RxOpretorlmpl mImpi;
    public SplashPresenter(IBaseView view){
        this.mView=view;
        mImpi=new RxOpretorlmpl();
    }

    @Override
    public void start(Object[] t) {
        super.start(t);
        HashMap<String, String> params =  new HashMap<>();
        params.put("device", (String) t[0]);
        mImpi.rxPostRequest(ApiConstants.DECODE, params, new CollBack() {
            @Override
            public void onSuccessData(Object o) {
                ResponseBody body = (ResponseBody) o;
                try {
                    String jsonStr = body.string();
                    LingBean lingBean = GsonUtil.str2Beas(jsonStr, LingBean.class);
                    if(mView!=null){
                        mView.onScuccess(lingBean);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    if(mView!=null){
                        mView.onError(e.getMessage());
                    }
                }
            }

            @Override
            public void onErrorMsg(String msg) {
                if(mView!=null){
                    mView.onError(msg);
                }
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addPosable(disposable);
            }


        });
    }
}
