package com.example.day15.presenter;

import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.model.RxOpretorlmpl;
import com.example.day15.ui.SelCourseActivity;

public class SelCourseActPresenter extends BasePresenter {

    private SelCourseActivity mView;
    private RxOpretorlmpl mImpl;
    public SelCourseActPresenter(SelCourseActivity activity) {
        this.mView = activity;
        mImpl=new RxOpretorlmpl();
    }

    @Override
    public void start() {
        super.start();
//        mImpl.rxPostRequest();
    }
}
