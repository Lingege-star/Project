package com.example.fuchanglin.Fragment.Discoover;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fuchanglin.Adapter.HotspotAdapter;
import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Presenter.DiscoverPresenter;
import com.example.fuchanglin.R;
import com.example.fuchanglin.base.BaseFragment;
import com.example.fuchanglin.interfac.Tongpao.IDiscover;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotSpotFragment  extends BaseFragment<DiscoverPresenter> implements IDiscover.View {


    @BindView(R.id.rlv_hotspot)
    RecyclerView rlvHotspot;
    //rivate List<News_1.DataBean.ListBean> listBeans;
    private HotspotAdapter hotspotAdapter;

    public HotSpotFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_hot_spot;
    }

    @Override
    protected void initView() {
        rlvHotspot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvHotspot.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        //listBeans = new ArrayList<>();
        hotspotAdapter = new HotspotAdapter(getActivity());
        rlvHotspot.setAdapter(hotspotAdapter);
    }

    @Override
    protected void initData() {
        presenter.getDiscoverHotspot();

    }

    @Override
    protected DiscoverPresenter createPresenter() {
        return new DiscoverPresenter(this);
    }

    @Override
    public void getDiscoverHotReturn(DiscoverHotshakyData result) {

    }

    @Override
    public void getDiscoverHotspotReturn(News_1 result) {
        hotspotAdapter.setList(result.getData().getList());
    }


    @Override
    public void getNavigationReturn(NavigationData result) {

    }

    @Override
    public void getMakeupDataReturn(MakeupData result) {

    }

    @Override
    public void tips(String tip) {

    }

    @Override
    public void loading(int visible) {

    }
}
