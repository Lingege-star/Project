package com.example.zuo_03.modle;

import com.example.zuo_03.collback.CollBack;
import com.example.zuo_03.modle.bean.TextBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TextModle {
    public void getText_tv(final CollBack collBack){
        new Retrofit.Builder()
                .baseUrl(Aciservct.Text_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aciservct.class)
                .getText()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        if(collBack!=null){
                            collBack.OKData(textBean);
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
