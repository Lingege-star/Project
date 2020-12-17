package com.example.a1217lian.view;


import com.example.a1217lian.bean.TuiJianBean;

public interface TuiView {
    void onSuccess(TuiJianBean tuiJianBean);

    void onFile(String msg);
}
