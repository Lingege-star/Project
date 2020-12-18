package com.example.api;

import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 项目名:My Application
 * 包名:com.example.api
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public interface ApiServer {
    String BASE_URL = "http://cdwan.cn:7000/tongpao/";
    //热门活动
    @GET("discover/hot_activity.json")
    Observable<HotInfo>getHot();
    //分类导航：
    @GET("discover/navigation.json")
    Observable<TabInfo>getTab();
    //对应的分类数据
    @GET("discover/news_{page}.json")
    Observable<NewsInfo>getNews(@Path("page")int page);
}
