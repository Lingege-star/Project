package com.example.fuchanglin.Presenter;

import android.view.View;

import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Model.DiscoverModel;
import com.example.fuchanglin.base.BasePresenter;
import com.example.fuchanglin.interfac.CallBack;
import com.example.fuchanglin.interfac.Tongpao.IDiscover;



public class DiscoverPresenter extends BasePresenter<IDiscover.View> implements IDiscover.Presenter{
    IDiscover.View view;
    IDiscover.Model model;

    public DiscoverPresenter(IDiscover.View view) {
        this.view = view;
        model = new DiscoverModel();
    }

    @Override
    public void getDiscoverHot() {
        model.loadDiscoverHot(new CallBack() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.loading(View.GONE);
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.loading(View.GONE);
                    view.getDiscoverHotReturn((DiscoverHotshakyData) o);
                }
            }
        });
    }

    @Override
    public void getDiscoverHotspot() {
        model.loadDiscoverHotspot(new CallBack() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.loading(View.GONE);
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.loading(View.GONE);
                    view.getDiscoverHotspotReturn((News_1) o);
                }
            }
        });
    }

    @Override
    public void getNavigationData() {
        model.loadNavigationData(new CallBack() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.loading(View.GONE);
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.loading(View.GONE);
                    view.getNavigationReturn((NavigationData) o);
                }
            }
        });
    }

    @Override
    public void getMakeupData() {
        model.loadMakeupData(new CallBack() {
            @Override
            public void fail(String msg) {
                if (view != null){
                    view.loading(View.GONE);
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null){
                    view.loading(View.GONE);
                    view.getMakeupDataReturn((MakeupData) o);
                }
            }
        });
    }
}
