package com.example.mvp.mvp.presenter;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.callback.RxObserverCallBack;
import com.example.mvp.mvp.model.RxOpretorImp1;
import com.example.mvp.mvp.model.constants.ApiConstants;
import com.example.mvp.mvp.ui.fragment.HomeFragment;

import java.io.IOException;

import okhttp3.ResponseBody;

public class HomeFrgPresenter extends BasePresenter {

    //加载网络框架的类对象
    private RxOpretorImp1 mImp1;
    private HomeFragment mHomeFragment;

    public HomeFrgPresenter(HomeFragment fragment) {
        mImp1 = new RxOpretorImp1();

        if (mView.get() instanceof HomeFragment) {
            this.mHomeFragment = fragment;//得到V层对象
        }


    }

    //重写加载数据的方法
    @Override
    public void start() {
        //向M层进行数据请求，因为封装了RxOpretorImp1类，可以直接调用，省略调用M层的方法
        //请求到数据之后将数据返回给V层
        //通过加载网络框架的对象调用方法,
        //网址常量在ApiConstants中设置
        mImp1.RxGetRequest(ApiConstants.RELEASE_BASE_URL, new RxObserverCallBack<Object>() {
            @Override//访问网咯成功
            public void onSuccessData(Object obj) {
                if (mHomeFragment != null) {
                    String str = (String) obj;
                    ResponseBody responseBody = (ResponseBody) obj;
                    try {
                        String string = responseBody.string();
                        //TODO gson解析
                        //这里暂时不需要，gson解析需要封装一个类
                        mHomeFragment.onSuccess(string);
                    } catch (IOException e) {
                        e.printStackTrace();
                        mHomeFragment.onError(e.getMessage());
                    }

                }
            }

            @Override
            public void onErrorMsg(String msg) {
                if (mHomeFragment != null) {
                    mHomeFragment.onError(msg);
                }
            }
        });
    }
}
