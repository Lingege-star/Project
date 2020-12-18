package com.example.a1218lian.view;


import com.example.a1218lian.bean.TuiJianBean;

public interface TuiView {
    void onSuccess(TuiJianBean tuiJianBean);

    void onFile(String msg);
}
