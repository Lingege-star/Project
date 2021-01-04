package com.example.day15.presenter;

import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.base.IBaseView;

public class SplashPresenter extends BasePresenter {
    private IBaseView mView;
    public SplashPresenter(IBaseView view){
        this.mView=view;
    }

}
