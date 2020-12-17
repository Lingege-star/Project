package com.example.p7_zuoye3.perster;

import com.example.p7_zuoye3.callback.ReqCallBack;
import com.example.p7_zuoye3.model.TuPianRecModel;
import com.example.p7_zuoye3.view.IView;

public class TuPianRecperster {
    private IView mIView;
    private final TuPianRecModel tuPianRecModel;

    public TuPianRecperster(IView mIView) {
        this.mIView = mIView;
        tuPianRecModel = new TuPianRecModel();
    }

    public void start(){
        tuPianRecModel.reqstart(new ReqCallBack() {
            @Override
            public void OKData(Object obj) {
                mIView.OKHottp(obj);
            }

            @Override
            public void NOData(String msg) {
                mIView.NOHottp(msg);
            }
        });
    }
}
