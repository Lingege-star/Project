package com.example.day04_test_01.net;

import com.example.day04_test_01.bean.EventsBean;
import com.example.day04_test_01.bean.TabBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    String sUrl = "http://cdwan.cn:7000/tongpao/";
    //热门活动
    @GET("discover/hot_activity.json")
    Flowable<EventsBean> getEvents();
    //列表标题
    @GET("discover/navigation.json")
    Flowable<TabBean> getTab();
}
