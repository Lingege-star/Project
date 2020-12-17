package com.example.day12_17.Presenter;

import com.example.day12_17.Bean.PicBean;
import com.example.day12_17.Bean.TextBean;
import com.example.day12_17.Bean.VideoBean;
import com.example.day12_17.Model.SofaModel;
import com.example.day12_17.MvpInterface.ResultCallBack;
import com.example.day12_17.View.SofaView;

public class SofaPresenter {
    private static final String TAG = "SofaPresenter";
    private SofaView view;
    private final SofaModel model;

    public SofaPresenter(SofaView view) {
        this.view = view;
        model = new SofaModel();
    }
    public void getdata(){
        model.getpic(new ResultCallBack<PicBean>() {
            @Override
            public void OnSuccess(PicBean picBean) {
                view.success(picBean);
            }

            @Override
            public void OnFile(String msg) {

            }
        });
        model.getvideo(new ResultCallBack<VideoBean>() {
            @Override
            public void OnSuccess(VideoBean videoBean) {
                view.success(videoBean);
            }

            @Override
            public void OnFile(String msg) {

            }
        });
        model.gettext(new ResultCallBack<TextBean>() {
            @Override
            public void OnSuccess(TextBean textBean) {
                view.success(textBean);
            }

            @Override
            public void OnFile(String msg) {

            }
        });
    }
}
