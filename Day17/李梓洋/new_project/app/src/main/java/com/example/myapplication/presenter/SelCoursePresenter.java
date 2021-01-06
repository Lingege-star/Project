package com.example.myapplication.presenter;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.base.IBaseView;
import com.example.mvplibrary.callback.RxObserverCallBack;
import com.example.mvplibrary.mvp.model.RxOpretorImpl;
import com.example.mvplibrary.mvp.model.constants.ApiConstants;
import com.example.mvplibrary.util.JsonUtil;
import com.example.myapplication.activity.SelCourseActivity;
import com.example.myapplication.bean.CourseSubBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class SelCoursePresenter extends BasePresenter {

    private final IBaseView view;
    private final RxOpretorImpl rxOpretor;
    private HashMap<String, String> hashMap;

    public SelCoursePresenter(IBaseView view) {
        super();
        this.view = view;
        rxOpretor = new RxOpretorImpl();
    }

    @Override
    public void start(Object[] t) {
        super.start(t);
        hashMap = new HashMap<>();
        hashMap.put("data",(String) t[0]);
        rxOpretor.rxPostRequest(ApiConstants.sel_course_Url, hashMap, new RxObserverCallBack<Object>() {
            @Override
            public void onSuccessData(Object o) {
                ResponseBody responseBody = (ResponseBody) o;

                try {
                    CourseSubBean subBean = JsonUtil.getJson(responseBody.string(), CourseSubBean.class);
                    view.onSuccess(subBean);

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
