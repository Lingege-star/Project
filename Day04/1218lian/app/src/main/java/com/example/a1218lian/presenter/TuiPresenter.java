package com.example.a1218lian.presenter;


import com.example.a1218lian.bean.TuiJianBean;
import com.example.a1218lian.modle.TuiModle;
import com.example.a1218lian.net.ResultCallBack;
import com.example.a1218lian.view.TuiView;

public class TuiPresenter {
    private TuiView view;
    private final TuiModle tuiModle;

    public TuiPresenter(TuiView tuiView) {

        view = tuiView;
        tuiModle = new TuiModle();
    }

    public void getData() {
        tuiModle.getData(new ResultCallBack<TuiJianBean>() {
            @Override
            public void onSuccess(TuiJianBean tuiJianBean) {
                view.onSuccess(tuiJianBean);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
