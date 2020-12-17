package com.example.day12_17.MvpInterface;

import com.example.day12_17.Bean.FindBean;
import com.example.day12_17.Bean.PicBean;
import com.example.day12_17.Bean.TextBean;
import com.example.day12_17.Bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String url = "http://123.56.232.18:8080/";

    //TODO 沙发 图片
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<PicBean> getpic();

    //TODO 沙发 视频
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video ")
    Observable<VideoBean> getvideo();

    //TODO  沙发 文本
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextBean> gettext();

    //TODO 发现  推荐
    @GET("serverdemo//tag/queryTagList")
    Observable<FindBean> getfind();

}
