package com.example.a1217lian.presenter;


import com.example.a1217lian.bean.TextBean;
import com.example.a1217lian.fragment.TextFragment;
import com.example.a1217lian.modle.TextModle;
import com.example.a1217lian.net.ResultCallBack;
import com.example.a1217lian.view.TextView;

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
