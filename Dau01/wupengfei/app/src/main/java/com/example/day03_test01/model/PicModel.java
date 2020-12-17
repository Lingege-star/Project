package com.example.day03_test01.model;

import com.example.day03_test01.bean.PicBean;
import com.example.day03_test01.net.ApiService;
import com.example.day03_test01.net.LogInterceptor;
import com.example.day03_test01.net.ResultCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicModel {
    public void getPic(final ResultCallBack<PicBean> callBack) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .build();
        new Retrofit.Builder()
                .client(client)
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getPic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new ResourceSubscriber<PicBean>() {
                   @Override
                   public void onNext(PicBean picBean) {
                    callBack.onSuccess(picBean);
                   }

                   @Override
                   public void onError(Throwable t) {
                    callBack.onFail(t.toString());
                   }

                   @Override
                   public void onComplete() {

                   }
               });

    }
}
