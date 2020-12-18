package com.example.fuchanglin.Fragment.Discoover;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fuchanglin.Adapter.MakeupAdapter;
import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Presenter.DiscoverPresenter;
import com.example.fuchanglin.R;
import com.example.fuchanglin.base.BaseFragment;
import com.example.fuchanglin.interfac.Tongpao.IDiscover;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakeupFragment extends BaseFragment<DiscoverPresenter> implements IDiscover.View {


    @BindView(R.id.makeup_rlv)
    RecyclerView makeupRlv;
    private List<MakeupData.DataBean.ListBean> list;
    private MakeupAdapter makeupAdapter;

    public MakeupFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_makeup;
    }

    @Override
    protected void initView() {
        makeupRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        makeupRlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        makeupAdapter = new MakeupAdapter(getActivity(), list);
        makeupRlv.setAdapter(makeupAdapter);
    }

    @Override
    protected void initData() {
        presenter.getMakeupData();
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

    }

    @Override
    public void getNavigationReturn(NavigationData result) {

    }

    @Override
    public void getMakeupDataReturn(MakeupData result) {
        list.clear();
        list.addAll(result.getData().getList());
        makeupAdapter.notifyDataSetChanged();
    }

    @Override
    public void tips(String tip) {

    }

    @Override
    public void loading(int visible) {

    }
}
