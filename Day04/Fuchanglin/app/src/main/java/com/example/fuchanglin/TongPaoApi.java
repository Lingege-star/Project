package com.example.fuchanglin;

import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.HotIssueData;
import com.example.fuchanglin.Bean.data.HotUserData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Bean.data.PersonalMeansData;
import com.example.fuchanglin.Bean.data.RecommendBannerData;
import com.example.fuchanglin.Bean.data.RecommendData;
import com.example.fuchanglin.Bean.data.SquareData;
import com.example.fuchanglin.Bean.data.TrandsData;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface TongPaoApi {

    String BASE_URL = "http://cdwan.cn:7000/tongpao/";

    @GET("home/recommend.json")
    Flowable<RecommendData> getRecommend();

    @GET("home/banner.json")
    Flowable<RecommendBannerData> getRecommendBanner();

    @GET("home/topic_discussed.json")
    Flowable<HotIssueData> getHotIssueData();

    @GET("home/hot_user.json")
    Flowable<HotUserData> getHotUserData();

    @GET("home/square.json")
    Flowable<SquareData> getSquareData();

    @GET("home/personal.json")
    Flowable<PersonalMeansData> getPersonalMeansData();

    @GET("home/personal_activity.json")
    Flowable<TrandsData> getTrandsData();

    @GET("discover/hot_activity.json")
    Flowable<DiscoverHotshakyData> getDiscoverHotData();

    @GET("discover/navigation.json")
    Flowable<NavigationData> getNavigationData();

    @GET("discover/news_1.json")
    Flowable<News_1> getHotspotData();

    @GET("discover/news_2.json")
    Flowable<MakeupData> getMakeupData();
}
