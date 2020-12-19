package com.example.Day05;

import com.example.Day05.bean.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Aciserict {
    public static final String Banner_URL="http://cdwan.cn:7000/tongpao/";
    @GET("home/banner.json")
    Observable<BannerBean> getBanner();
}
