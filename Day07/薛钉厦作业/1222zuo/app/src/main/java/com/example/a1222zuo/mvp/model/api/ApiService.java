package com.example.a1222zuo.mvp.model.api;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> requestGetData(@Url String url);
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url, @HeaderMap HashMap<String, T> headers);
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url, @QueryMap Map<String, T> params);
    @GET
    <T> Observable<ResponseBody> requestGetData(@Url String url,
                                                @HeaderMap Map<String, T> headers,
                                                @QueryMap Map<String, T> params);
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> requestPostData(@Url String url);
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap HashMap<String, T> headers);
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @FieldMap Map<String, T> params);
    @POST
    @FormUrlEncoded
    <T>
    Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap Map<String, T> headers,
                                             @FieldMap Map<String, T> params);

    @POST
    Observable<ResponseBody> requestPostData(@Url String url, @Body RequestBody body);
    @POST
    <T> Observable<ResponseBody> requestPostData(@Url String url, @HeaderMap Map<String, T> headers, @Body RequestBody body);
    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String fileUrl, String fileSavePath);
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body,
                                        @Part MultipartBody.Part part);


    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part... part);
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @Part MultipartBody.Part... part);

    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part part);
    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part part);

    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part... part);

    @POST
    @Multipart
    <T>
    Observable<ResponseBody> uploadFile(@Url String url, @Body RequestBody body, @HeaderMap Map<String, T> headers,
                                        @Part MultipartBody.Part... part);

}