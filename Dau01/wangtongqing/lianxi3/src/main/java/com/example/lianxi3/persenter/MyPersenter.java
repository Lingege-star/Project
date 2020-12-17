package com.example.lianxi3.persenter;

import com.example.lianxi3.bean.LikeInfo;
import com.example.lianxi3.bean.PicInfo;
import com.example.lianxi3.bean.TextInfo;
import com.example.lianxi3.bean.VideoInfo;
import com.example.lianxi3.model.MyModel;
import com.example.lianxi3.view.CallBack;
import com.example.lianxi3.view.MyView;

/**
 * 项目名:My Application
 * 包名:com.example.lianxi3.persenter
 * 创建者: WangTQ
 * 创建时间: 2020/12/17
 */
public class MyPersenter {
    MyView view;
    MyModel model;

    public MyPersenter(MyView view) {
        this.view = view;
        model = new MyModel();
    }

    public void getPic(String page, String type) {
        model.getPicInfo(page, type, new CallBack<PicInfo>() {
            @Override
            public void OnSuecss(PicInfo picInfo) {
                if (view != null) {
                    view.OnSuecss(picInfo);
                }

            }

            @Override
            public void OnFaile(String msg) {
                if (view != null) {
                    view.OnFaile(msg);
                }
            }
        });
    }

    public void getVideo(String page, String type) {
        model.getVideo(page, type, new CallBack<VideoInfo>() {
            @Override
            public void OnSuecss(VideoInfo videoInfo) {
                if (view != null) {
                    view.OnSuecss(videoInfo);

                }
            }

            @Override
            public void OnFaile(String msg) {
                if (view != null) {
                    view.OnFaile(msg);
                }
            }
        });
    }

    public void getText(String page, String type) {
        model.getText(page,type, new CallBack<TextInfo>() {
            @Override
            public void OnSuecss(TextInfo textInfo) {
                if (view != null) {
                    view.OnSuecss(textInfo);

                }
            }

            @Override
            public void OnFaile(String msg) {
                if (view != null) {
                    view.OnFaile(msg);
                }
            }
        });
    }

    public void getLiKe() {
        model.getLike(new CallBack<LikeInfo>() {
            @Override
            public void OnSuecss(LikeInfo likeInfo) {
                if (view != null) {
                    view.OnSuecss(likeInfo);

                }
            }

            @Override
            public void OnFaile(String msg) {
                if (view != null) {
                    view.OnFaile(msg);

                }
            }
        });
    }
}
