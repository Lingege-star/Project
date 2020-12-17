package com.example.a1217lian.net;

public interface ResultCallBack<T> {
    void onSuccess(T t);

    void onFile(String msg);
}
