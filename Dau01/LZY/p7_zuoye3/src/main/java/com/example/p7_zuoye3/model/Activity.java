package com.example.p7_zuoye3.model;

import com.example.p7_zuoye3.model.bean.MovieBean;
import com.example.p7_zuoye3.model.bean.TextBean;
import com.example.p7_zuoye3.model.bean.TuPianBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Activity {
    public static final String REC_Tu="http://123.56.232.18:8080/serverdemo/feeds/";
    public static final String REC_Mov="http://123.56.232.18:8080/serverdemo/feeds/";
    public static final String REC_Text="http://123.56.232.18:8080/serverdemo/feeds/";

//    @GET("queryHotFeedsList")
//    Observable<TuPianBean>getTuPianBean(@Query("pageCount") int page,@Query("feedType") String feedType);
    @GET("queryHotFeedsList")
    Observable<MovieBean>getMovieBean(@Query("pageCount") int page, @Query("feedType") String feedType);

    @GET
    Observable<TuPianBean>getTuPianBean(@Url String url);
//    @GET
//    Observable<MovieBean>getMovieBean(@Url String url);
    @GET
    Observable<TextBean>getTextBean(@Url String url);
}
