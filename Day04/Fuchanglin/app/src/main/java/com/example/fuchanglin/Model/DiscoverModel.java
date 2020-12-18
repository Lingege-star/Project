package com.example.fuchanglin.Model;

import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Utils.RxUtils;
import com.example.fuchanglin.base.BaseModel;
import com.example.fuchanglin.interfac.CallBack;
import com.example.fuchanglin.interfac.Tongpao.IDiscover;


import com.example.fuchanglin.net.CommonSubscriber;
import com.example.fuchanglin.net.HttpManager;

import io.reactivex.disposables.Disposable;

public class DiscoverModel extends BaseModel implements IDiscover.Model {
    private CallBack callBack;

    @Override
    public void loadDiscoverHot(final CallBack callBack) {
        addDisposable(HttpManager.getInstance().getTongPaoApi().getDiscoverHotData()
                .compose(RxUtils.<DiscoverHotshakyData>rxScheduler())
                .subscribeWith(new CommonSubscriber<DiscoverHotshakyData>(callBack) {
                    @Override
                    public void onNext(DiscoverHotshakyData discoverHotshakyData) {
                        callBack.success(discoverHotshakyData);
                    }
                })

        );
    }

    @Override
    public void loadDiscoverHotspot(final CallBack callBack) {
        addDisposable(
                HttpManager.getInstance().getTongPaoApi().getHotspotData()
                        .compose(RxUtils.<News_1>rxScheduler())
                        .subscribeWith(new CommonSubscriber<News_1>(callBack) {
                            @Override
                            public void onNext(News_1 news_1) {
                               callBack.success(news_1);
                            }
                        })
        );
    }

    @Override
    public void loadNavigationData(final CallBack callBack) {
        addDisposable(
                HttpManager.getInstance().getTongPaoApi().getNavigationData()
                        .compose(RxUtils.<NavigationData>rxScheduler())
                        .subscribeWith(new CommonSubscriber<NavigationData>(callBack) {
                            @Override
                            public void onNext(NavigationData navigationData) {
                                callBack.success(navigationData);
                            }
                        })
        );
    }

    @Override
    public void loadMakeupData(final CallBack callBack) {
        addDisposable(
                HttpManager.getInstance().getTongPaoApi().getMakeupData()
                        .compose(RxUtils.<MakeupData>rxScheduler())
                        .subscribeWith(new CommonSubscriber<MakeupData>(callBack) {
                            @Override
                            public void onNext(MakeupData makeupData) {
                                callBack.success(makeupData);
                            }
                        })
        );
    }


}
