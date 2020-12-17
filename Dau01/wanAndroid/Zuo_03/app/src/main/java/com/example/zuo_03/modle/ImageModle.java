package com.example.zuo_03.modle;

import android.util.Log;

import com.example.zuo_03.collback.CollBack;
import com.example.zuo_03.modle.bean.ImageBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageModle {
    public void getImg(final CollBack collBack){
        new Retrofit.Builder()
                .baseUrl(Aciservct.Img_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Aciservct.class)
                .getImg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        if(collBack!=null){
                            collBack.OKData(imageBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(collBack!=null){
                            collBack.NOData(e.getMessage());
                            Log.e("TAG","数据加载失败"+e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
