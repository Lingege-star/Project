package com.example;

import com.example.IBase.CallBack;
import com.example.IBase.IBaseModel;
import com.example.IBase.IBasePresenter;
import com.example.IBase.IBaseView;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;

/**
 * 项目名:My Application
 * 包名:com.example
 * 创建者: WangTQ
 * 创建时间: 2020/12/18
 */
public interface MyInterface {
    interface view extends IBaseView {
        void gethot(HotInfo hotInfo);

        void gettab(TabInfo tabInfo);

        void getnews(NewsInfo newsInfo);
    }

    interface presenter extends IBasePresenter<view> {
        void gethot();

        void gettab();

        void getnews(int page);
    }

    interface model extends IBaseModel {
        void gethot(CallBack callBack);

        void gettab(CallBack callBack);

        void getnesw(int page, CallBack callBack);
    }
}
