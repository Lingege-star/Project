package com.example.fuchanglin.interfac;

public interface CallBack<T> {
    void fail(String msg);

    void success(T t);
}
