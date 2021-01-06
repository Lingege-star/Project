package com.example.myapplication.presenter;

import android.view.View;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.base.IBaseView;
import com.example.mvplibrary.callback.RxObserverCallBack;
import com.example.mvplibrary.mvp.model.RxOpretorImpl;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.mvplibrary.util.JsonUtil;
import com.example.myapplication.R;
import com.example.myapplication.activity.GuideActivity;
import com.example.myapplication.bean.DeviceBean;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class GuidePresenter extends BasePresenter {

    private final IBaseView view;
    private final RxOpretorImpl rxOpretor;
    private HashMap<String, String> map;

    public GuidePresenter(IBaseView view) {
        this.view = view;
        rxOpretor = new RxOpretorImpl();
    }

    @Override
    public void start(Object[] t) {
        super.start(t);
        map = new HashMap<>();
        String str = (String) t[0];
        map.put("device", str);
        rxOpretor.rxPostRequest(ApiConstants.api_Url, map, new RxObserverCallBack() {
            @Override
            public void onSuccessData(Object o) {
                    ResponseBody responseBody = (ResponseBody) o;
                DeviceBean bean = null;
                try {
                    bean = JsonUtil.getJson(responseBody.string(), DeviceBean.class);
                    view.onSuccess(bean);
                } catch (IOException e) {
                    e.printStackTrace();
                    view.onFail(e.toString());
                }



            }

            @Override
            public void onErrorMsg(String msg) {
                view.onFail(msg);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addDisposable(disposable);
            }
        });
    }
}
