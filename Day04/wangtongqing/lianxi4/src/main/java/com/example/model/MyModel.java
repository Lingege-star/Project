package com.example.model;

import android.util.Log;

import com.example.IBase.CallBack;
import com.example.MyInterface;
import com.example.api.ApiServer;
import com.example.base.BaseModel;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;
import com.example.manager.NetManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名:My Application
 * 包名:com.example.model
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public class MyModel extends BaseModel implements MyInterface.model {
    @Override
    public void gethot(final CallBack callBack) {
        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HotInfo>() {
                    @Override
                    public void accept(HotInfo hotInfo) throws Exception {
                        if (hotInfo!=null){
                            callBack.OnSucess(hotInfo);
                        }
                    }
                });
    }

    @Override
    public void gettab(CallBack callBack) {
        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getTab()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TabInfo>() {
                    @Override
                    public void accept(TabInfo tabInfo) throws Exception {
                        if (tabInfo!=null){
                            callBack.OnSucess(tabInfo);
                        }
                    }
                });
    }

    @Override
    public void getnesw(int page, CallBack callBack) {
        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getNews(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsInfo newsInfo) {
                            if(newsInfo!=null){
                                callBack.OnSucess(newsInfo);
                            }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", "onError: " +e.getMessage());
                            callBack.faile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
