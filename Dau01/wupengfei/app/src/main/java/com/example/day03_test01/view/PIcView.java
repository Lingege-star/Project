package com.example.day03_test01.view;

import com.example.day03_test01.bean.PicBean;

public interface PIcView {

    void picOnSuccess(PicBean picBean);
    void picOnFail(String msg);


}
