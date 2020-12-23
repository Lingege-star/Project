package com.example.myapplication.presenter;

import com.example.myapplication.callback.CallBack;
import com.example.myapplication.model.MyModel;
import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.ui.MainActivity;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.presenter
 * 创建者: WangTQ
 * 创建时间: 2020/12/21
 */
public class MyPresenter extends BasePersenter {
    private MyModel myModel;
    private MainActivity mainActivity;

    public MyPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        myModel = new MyModel();
    }

    @Override
    public void start() {
        myModel.requestData(new CallBack<String>() {
            @Override
            public void OnOk(String s) {
                mainActivity.OnSucess(s);
            }

            @Override
            public void OnNo(String msg) {
                mainActivity.OnFile(msg);
            }
        });
    }
}
