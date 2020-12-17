package com.example.zuo_03.paresrcte;

import com.example.zuo_03.collback.CollBack;
import com.example.zuo_03.modle.ImageModle;
import com.example.zuo_03.modle.ShiModle;
import com.example.zuo_03.modle.TextModle;
import com.example.zuo_03.modle.TuModle;
import com.example.zuo_03.view.IView;

public class Parsetcay {
    private IView iView;
    private final ImageModle imageModle;
    private final ShiModle shiModle;
    private final TextModle textModle;
    private final TuModle tuModle;

    public Parsetcay(IView iView){
        this.iView=iView;
        imageModle = new ImageModle();
        shiModle = new ShiModle();
        textModle = new TextModle();
        tuModle = new TuModle();
    }
    public void start(){
        imageModle.getImg(new CollBack() {
            @Override
            public void OKData(Object obj) {
                iView.ShowOK(obj);
            }

            @Override
            public void NOData(String no) {
                iView.ShowNO(no);
            }
        });
        shiModle.getShi(new CollBack() {
            @Override
            public void OKData(Object obj) {
                iView.ShowOK(obj);
            }

            @Override
            public void NOData(String no) {
                iView.ShowNO(no);
            }
        });
        textModle.getText_tv(new CollBack() {
            @Override
            public void OKData(Object obj) {
                iView.ShowOK(obj);
            }

            @Override
            public void NOData(String no) {
                iView.ShowNO(no);
            }
        });
        tuModle.get_tu_name(new CollBack() {
            @Override
            public void OKData(Object obj) {
                iView.ShowOK(obj);
            }

            @Override
            public void NOData(String no) {
                iView.ShowNO(no);
            }
        });
    }
}
