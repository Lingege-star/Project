package com.example.presenter;

import com.example.IBase.CallBack;
import com.example.MyInterface;
import com.example.base.BasePresenter;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;
import com.example.model.MyModel;

/**
 * 项目名:My Application
 * 包名:com.example.presenter
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public class MyPersenter extends BasePresenter<MyInterface.view> implements MyInterface.presenter {
    MyInterface.view view;
    MyInterface.model model;

    public MyPersenter(MyInterface.view view) {
        this.view = view;
        model = new MyModel();
    }

    @Override
    public void gethot() {
        model.gethot(new CallBack() {
            @Override
            public void OnSucess(Object o) {
                if (view != null) {
                    view.gethot((HotInfo) o);
                }
            }

            @Override
            public void faile(String msg) {
                if (view != null) {
                    view.onfaile(msg);
                }
            }
        });
    }

    @Override
    public void gettab() {
        model.gettab(new CallBack() {
            @Override
            public void OnSucess(Object o) {
                if (view != null) {
                    view.gettab((TabInfo) o);
                }
            }

            @Override
            public void faile(String msg) {
                if (view != null) {
                    view.onfaile(msg);
                }
            }
        });
    }

    @Override
    public void getnews(int page) {
        model.getnesw(page, new CallBack() {
            @Override
            public void OnSucess(Object o) {
                if (view != null) {
                    view.getnews((NewsInfo) o);
                }
            }

            @Override
            public void faile(String msg) {
                if (view != null) {
                    view.onfaile(msg);
                }
            }
        });
    }

}
