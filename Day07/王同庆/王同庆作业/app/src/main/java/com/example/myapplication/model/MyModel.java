package com.example.myapplication.model;

import com.example.myapplication.callback.CallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.model
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class MyModel {
    public void requestData(CallBack callBack) {
        Request build = new Request.Builder().url("http://www.zongheng.com/category/1.html").build();
        new OkHttpClient().newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.OnNo(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                callBack.OnOk(s);
            }
        });



    }
}
