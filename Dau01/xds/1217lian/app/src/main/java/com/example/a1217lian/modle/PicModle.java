package com.example.a1217lian.modle;

import com.example.a1217lian.bean.PicBean;
import com.example.a1217lian.net.ApiService;
import com.example.a1217lian.net.ResultCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicModle {
    public void getPic(final ResultCallBack<PicBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.picUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getPic(12,"pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<PicBean>() {
                    @Override
                    public void onNext(PicBean picBean) {
                        callBack.onSuccess(picBean);
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
