package com.example.p7_zuoye4;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Activity {
    public static final String Rec_ZZ="http://cdwan.cn:7000/";
    public static final String Rec_Hot="http://cdwan.cn:7000/";

    @GET
    Observable<HotBean>getHotBean(@Url String url);
    @GET
    Observable<ZhuangZaoBean>getZhuangZaoBean(@Url String url);
}
