package com.example.lianxi3;

import com.example.lianxi3.bean.LikeInfo;
import com.example.lianxi3.bean.PicInfo;
import com.example.lianxi3.bean.TextInfo;
import com.example.lianxi3.bean.VideoInfo;

import java.util.HashMap;
import java.util.Objects;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public interface ApiServer {
    String BASE_URL = "http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList")
    Observable<PicInfo> getPic(@QueryMap() HashMap<String, String> map);

    @GET("feeds/queryHotFeedsList")
    Observable<VideoInfo> getVideo(@QueryMap() HashMap<String, String> map);

    @GET("feeds/queryHotFeedsList")
    Observable<TextInfo> getText(@QueryMap() HashMap<String, String> map);

    @GET("tag/queryTagList")
    Observable<LikeInfo>getLike();

}
