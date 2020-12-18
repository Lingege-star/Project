package com.example.Day02;

import com.example.Day02.bean.ReBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Aciserect {
    public static final String RE_URL="http://cdwan.cn:7000/tongpao/";
    @GET("discover/hot_activity.json")
    Observable<ReBean> getRe();
}
