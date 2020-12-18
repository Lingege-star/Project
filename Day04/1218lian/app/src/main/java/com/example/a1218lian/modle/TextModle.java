package com.example.a1218lian.modle;





import com.example.a1218lian.bean.TextBean;
import com.example.a1218lian.net.ApiService;
import com.example.a1218lian.net.ResultCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TextModle {
    public void getData(final ResultCallBack<TextBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.picUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getText(10,"text",1578920275)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TextBean>() {
                    @Override
                    public void onNext(TextBean textBean) {
                        callBack.onSuccess(textBean);
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
