package com.example.p7_zuoye3.model;

import com.example.p7_zuoye3.callback.ReqCallBack;
import com.example.p7_zuoye3.model.bean.TuPianBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TuPianRecModel {
    public void reqstart(ReqCallBack callBack){
        new Retrofit.Builder()
                .baseUrl(Activity.REC_Tu)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Activity.class)
                .getTuPianBean("http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuPianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuPianBean tuPianBean) {
                        if(callBack!=null){
                            callBack.OKData(tuPianBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callBack!=null){
                            callBack.NOData(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
