package com.example.zuo_03.modle;

import com.example.zuo_03.collback.CollBack;
import com.example.zuo_03.modle.bean.ShiBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShiModle {
    public void getShi(final CollBack collBack){
        new Retrofit.Builder()
                .baseUrl(Aciservct.Shi_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Aciservct.class)
                .getshiping()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiBean shiBean) {
                        if(collBack!=null){
                            collBack.OKData(shiBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(collBack!=null){
                            collBack.NOData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
