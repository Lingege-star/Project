package com.example.a1218lian.presenter;


import com.example.a1218lian.bean.ViewBean;
import com.example.a1218lian.modle.ViewModle;
import com.example.a1218lian.net.ResultCallBack;
import com.example.a1218lian.view.ViewView;

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
