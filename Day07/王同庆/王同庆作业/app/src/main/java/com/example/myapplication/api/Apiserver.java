package com.example.myapplication.api;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.api
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public interface Apiserver {

    @GET
    Observable<ResponseBody> requestgetData(@Url String url);

    @GET
    <T> Observable<ResponseBody> requestgetData(@Url String url, @QueryMap HashMap<String, T> headers);

    @GET
    <T> Observable<ResponseBody> requestgetData(@Url String url, @HeaderMap Map<String, T> headers);

    @GET
    <T> Observable<ResponseBody> requestgetData(@Url String url, @HeaderMap Map<String, T> headers, @QueryMap HashMap<String, T> headerss);

    @POST
    Observable<ResponseBody> requestPostData(@Url String url);

    @POST
    @FormUrlEncoded
    <T> Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap HashMap<String, T> headers);

    @POST
    @FormUrlEncoded
    <T> Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> headers);

    @POST
    @FormUrlEncoded
    <T> Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> headers, @HeaderMap HashMap<String, T> headerss);

    //请求体是json串的post请求
    @POST
    Observable<ResponseBody> requestPostData(@Url String url, @Body RequestBody body);


    //带请求头并且请求体是json串的post请求
    @POST
    <T> Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> headers, @Body RequestBody body);

    //下载   1.下载文件路径   2.文件保存路径
    @GET
    @Streaming
    Observer<RequestBody> doenLoadFile(@Url String url, String fileSavePath);

    //不带请求头的单文件上传
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);


    //不带请求头 单文件+字符串上传
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body,
                                        @Part MultipartBody.Part part);


    //不带请求头的多文件上传
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part... part);


    //不带请求头的  字符串+多文件上传
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @Part MultipartBody.Part... part);


    //带请求头的单文件上传
    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part part);

    //带请求头的  字符串+单文件上传
    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part part);


    //带请求头的多文件上传
    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part... part);


    //带请求头的  字符串+多文件上传
    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part... part);


}
