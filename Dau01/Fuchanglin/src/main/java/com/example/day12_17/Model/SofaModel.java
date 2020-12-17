package com.example.day12_17.Model;

import android.util.Log;

import com.example.day12_17.Bean.PicBean;
import com.example.day12_17.Bean.TextBean;
import com.example.day12_17.Bean.VideoBean;
import com.example.day12_17.MvpInterface.ApiService;
import com.example.day12_17.MvpInterface.ResultCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SofaModel {
    private static final String TAG = "SofaModel";
    ApiService apiService = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiService.url)
            .build()
            .create(ApiService.class);
    public void getpic(final ResultCallBack<PicBean> callBack) {

        //TODO 得到pic
        apiService
                .getpic()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PicBean picBean) {
                        callBack.OnSuccess(picBean);
                        Log.d(TAG, "onNext: " + picBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
    public void getvideo(final ResultCallBack<VideoBean> callBack){
        //TODO 得到Video
        apiService.getvideo()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        callBack.OnSuccess(videoBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void gettext(final ResultCallBack<TextBean> callBack){

        //TODO 得到文本
        apiService.gettext()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        callBack.OnSuccess(textBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
