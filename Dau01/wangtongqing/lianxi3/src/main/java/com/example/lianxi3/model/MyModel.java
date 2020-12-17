package com.example.lianxi3.model;

import com.example.lianxi3.ApiServer;
import com.example.lianxi3.bean.LikeInfo;
import com.example.lianxi3.bean.PicInfo;
import com.example.lianxi3.bean.TextInfo;
import com.example.lianxi3.bean.VideoInfo;
import com.example.lianxi3.manager.NetManager;
import com.example.lianxi3.view.CallBack;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.model
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class MyModel {
    public void getPicInfo(String page, String type, CallBack<PicInfo> CallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("pageCount", page);
        map.put("feedType", type);

        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getPic(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PicInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PicInfo picInfo) {
                        if (picInfo != null) {
                            CallBack.OnSuecss(picInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        CallBack.OnFaile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getVideo(String page, String type, CallBack<VideoInfo> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pageCount", page);
        map.put("feedType", type);

        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getVideo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoInfo videoInfo) {
                        if (videoInfo != null) {
                            callBack.OnSuecss(videoInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.OnFaile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getText(String page, String type, CallBack<TextInfo> textCallBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pageCount", page);
        map.put("feedType", type);

        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getText(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextInfo textInfo) {
                        if (textInfo != null) {
                            textCallBack.OnSuecss(textInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        textCallBack.OnFaile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getLike(CallBack<LikeInfo> likeCallBack) {
        NetManager.getRetrofit(ApiServer.BASE_URL)
                .create(ApiServer.class).getLike()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LikeInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LikeInfo likeInfo) {
                        if (likeInfo != null) {
                            likeCallBack.OnSuecss(likeInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        likeCallBack.OnFaile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
