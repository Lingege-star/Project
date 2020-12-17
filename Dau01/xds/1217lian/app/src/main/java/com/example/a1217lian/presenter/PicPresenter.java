package com.example.a1217lian.presenter;


import com.example.a1217lian.bean.PicBean;
import com.example.a1217lian.modle.PicModle;
import com.example.a1217lian.net.ResultCallBack;
import com.example.a1217lian.view.PicView;

public class PicPresenter {
    private PicView view;
    private final PicModle picModle;

    public PicPresenter(PicView picView) {

        view = picView;
        picModle = new PicModle();
    }

    public void getPic() {
        picModle.getPic(new ResultCallBack<PicBean>() {
            @Override
            public void onSuccess(PicBean picBean) {
                view.onSuccess(picBean);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
