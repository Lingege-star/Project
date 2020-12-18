package com.example.a1218lian.presenter;


import com.example.a1218lian.bean.TextBean;
import com.example.a1218lian.fragment.TextFragment;
import com.example.a1218lian.modle.TextModle;
import com.example.a1218lian.net.ResultCallBack;
import com.example.a1218lian.view.TextView;

public class TextPresenter {
    private TextView view;
    private final TextModle textModle;

    public TextPresenter(TextFragment textView) {

        view = textView;
        textModle = new TextModle();
    }

    public void getData() {
        textModle.getData(new ResultCallBack<TextBean>() {
            @Override
            public void onSuccess(TextBean textBean) {
                view.onSuccess(textBean);
            }

            @Override
            public void onFile(String msg) {
                view.onFile(msg);
            }
        });
    }
}
