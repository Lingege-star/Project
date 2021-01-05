package com.example.day15.presenter;

import android.widget.ImageView;

import com.example.day15.Util.GsonUtil;
import com.example.day15.map.Manager.ContainManager;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.base.IBaseView;
import com.example.day15.map.collback.CollBack;
import com.example.day15.map.model.RxOpretorlmpl;
import com.example.day15.map.model.bean.XuanBean;
import com.example.day15.map.model.constants.ApiConstants;
import com.example.day15.ui.SelCourseActivity;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class SelCourseActPresenter extends BasePresenter {

    private IBaseView mView;
    private RxOpretorlmpl mImpl;
    public SelCourseActPresenter(IBaseView activity) {
        this.mView = activity;
        mImpl=new RxOpretorlmpl();
    }

    @Override
    public void start() {
        super.start();
        HashMap<String, String> params =  new HashMap<>();
        String decode= ContainManager.getManager().get_str("decode");
        params.put("decode",decode);
        mImpl.rxPostRequest(ApiConstants.SEL_COURSE, params, new CollBack() {

            @Override
            public void onSuccessData(Object o) {
                ResponseBody body= (ResponseBody) o;
                try {
                    String jsonStr = body.string();
                    XuanBean xuanBean = GsonUtil.str2Beas(jsonStr, XuanBean.class);
                    if(mView!=null){
                        mView.onScuccess(xuanBean);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if(mView!=null){
                        mView.onError(e.getMessage());
                    }
                }
            }

            @Override
            public void onErrorMsg(String msg) {
                if(mView!=null){
                    mView.onError(msg);
                }
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                addPosable(disposable);
            }
        });

    }
}
