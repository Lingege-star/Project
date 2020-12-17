package com.example.a1217lian.modle;



import com.example.a1217lian.bean.ViewBean;
import com.example.a1217lian.net.ApiService;
import com.example.a1217lian.net.ResultCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModle {
    public void getData(final ResultCallBack<ViewBean> callBack) {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.picUrl)
                .build()
                .create(ApiService.class)
                .getView(12,"video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ViewBean>() {
                    @Override
                    public void onNext(ViewBean viewBean) {
                        callBack.onSuccess(viewBean);
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
