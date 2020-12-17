package com.example.day03_test01.net;

import com.example.day03_test01.bean.PicBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics  沙发—图片
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video 沙发—视频
//    http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275沙发— 文本
//    http://123.56.232.18:8080/serverdemo//tag/queryTagList          发现—推荐


    String sUrl = " http://123.56.232.18:8080/serverdemo/";

    @GET("feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Flowable<PicBean> getPic();



}
