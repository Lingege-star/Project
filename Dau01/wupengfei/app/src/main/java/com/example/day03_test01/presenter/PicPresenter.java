package com.example.day03_test01.presenter;

import com.example.day03_test01.bean.PicBean;
import com.example.day03_test01.fragment.PicFragment;
import com.example.day03_test01.model.PicModel;
import com.example.day03_test01.net.ResultCallBack;
import com.example.day03_test01.view.PIcView;

public class PicPresenter {
    private final PicModel picModel;
    private PIcView mView;

    public PicPresenter(PIcView view) {

        mView = view;
        picModel = new PicModel();
    }

    public void getData() {
       picModel.getPic(new ResultCallBack<PicBean>() {
           @Override
           public void onSuccess(PicBean picBean) {
               mView.picOnSuccess(picBean);
           }

           @Override
           public void onFail(String msg) {
                mView.picOnFail(msg);
           }
       });
    }
}
