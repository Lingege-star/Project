package com.example.zuo_03.modle;

import com.example.zuo_03.modle.bean.ImageBean;
import com.example.zuo_03.modle.bean.ShiBean;
import com.example.zuo_03.modle.bean.TextBean;
import com.example.zuo_03.modle.bean.TuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Aciservct {
    public static final String Img_URL="http://123.56.232.18:8080/";
    public static final String Shi_URL="http://123.56.232.18:8080/";
    public static final String Text_URL="http://123.56.232.18:8080/";
    public static final String Tu_URL="http://123.56.232.18:8080/";
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
    Observable<ImageBean> getImg();
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=video")
    Observable<ShiBean> getshiping();
    @GET("serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
    Observable<TextBean> getText();
    @GET("serverdemo//tag/queryTagList")
    Observable<TuBean> getTu();
}
