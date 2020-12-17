package com.example.a1217lian.presenter;


import com.example.a1217lian.bean.ViewBean;
import com.example.a1217lian.modle.ViewModle;
import com.example.a1217lian.net.ResultCallBack;
import com.example.a1217lian.view.ViewView;

public class ViewPresenter {
    private ViewView view;
    private final ViewModle viewModle;

    public ViewPresenter(ViewView viewView) {
        view = viewView;
        viewModle = new ViewModle();
    }

    public void getData() {
        viewModle.getData(new ResultCallBack<ViewBean>() {
            @Override
            public void onSuccess(ViewBean viewBean) {
                view.onSuccess(viewBean);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
