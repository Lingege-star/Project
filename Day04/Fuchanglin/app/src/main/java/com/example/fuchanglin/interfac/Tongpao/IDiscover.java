package com.example.fuchanglin.interfac.Tongpao;

import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.interfac.CallBack;
import com.example.fuchanglin.interfac.IBasePresenter;
import com.example.fuchanglin.interfac.IBaseView;

public interface IDiscover {
    interface View extends IBaseView {

        void getDiscoverHotReturn(DiscoverHotshakyData result);
        void getDiscoverHotspotReturn(News_1 result);
        void getNavigationReturn(NavigationData result);
        void getMakeupDataReturn(MakeupData result);
    }

    interface Presenter extends IBasePresenter<View> {

        void getDiscoverHot();
        void getDiscoverHotspot();
        void getNavigationData();
        void getMakeupData();

    }

    interface Model extends IModel {
        void loadDiscoverHot(CallBack callBack);
        void loadDiscoverHotspot(CallBack callBack);
        void loadNavigationData(CallBack callBack);
        void loadMakeupData(CallBack callBack);
    }
}
