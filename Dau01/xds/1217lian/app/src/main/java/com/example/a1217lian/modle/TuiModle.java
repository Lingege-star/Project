package com.example.a1217lian.modle;

import com.example.a1217lian.bean.TuiJianBean;
import com.example.a1217lian.net.ApiService;
import com.example.a1217lian.net.ResultCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TuiModle {
    public void getData(final ResultCallBack<TuiJianBean> callBack) {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.mUrl)
                .build()
                .create(ApiService.class)
                .getTui()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TuiJianBean>() {
                    @Override
                    public void onNext(TuiJianBean tuiJianBean) {
                        callBack.onSuccess(tuiJianBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFile(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
