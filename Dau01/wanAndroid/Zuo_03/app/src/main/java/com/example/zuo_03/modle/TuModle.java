package com.example.zuo_03.modle;

import com.example.zuo_03.collback.CollBack;
import com.example.zuo_03.modle.bean.TuBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TuModle {
    public void get_tu_name(final CollBack collBack){
        new Retrofit.Builder()
                .baseUrl(Aciservct.Tu_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Aciservct.class)
                .getTu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuBean tuBean) {
                        if(collBack!=null){
                            collBack.OKData(tuBean);
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
