package com.example.a1218lian.net;





import com.example.a1218lian.bean.PicBean;
import com.example.a1218lian.bean.TextBean;
import com.example.a1218lian.bean.TuiJianBean;
import com.example.a1218lian.bean.ViewBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String picUrl = "http://123.56.232.18:8080/serverdemo/feeds/";

    @GET("queryHotFeedsList")
    Flowable<PicBean> getPic(@Query("pageCount") int pageCount,
                             @Query("feedType") String feedType);

//    http://123.56.232.18:8080/serverdemo/feeds/

    @GET("queryHotFeedsList")
    Flowable<ViewBean> getView(@Query("pageCount") int pageCount,
                               @Query("feedType") String feedType);

//    http://123.56.232.18:8080/serverdemo/feeds/
    @GET("queryHotFeedsList")
    Flowable<TextBean> getText(@Query("pageCount") int pageCount,
                               @Query("feedType") String feedType,
                               @Query("feedId") int feedId);

//    http://123.56.232.18:8080/serverdemo//tag/queryTagList
    String mUrl="http://123.56.232.18:8080/";
    @GET("serverdemo//tag/queryTagList")
    Flowable<TuiJianBean> getTui();
}

