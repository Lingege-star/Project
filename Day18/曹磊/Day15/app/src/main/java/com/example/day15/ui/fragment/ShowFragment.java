package com.example.day15.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.BaseFragment;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.ui.ShowAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.slr)
    SmartRefreshLayout slr;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        slr.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                slr.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                slr.finishRefresh();
            }
        });

        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<View> list = new ArrayList<>();
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_banner, null);
        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.item_tab, null);
        View view3 = LayoutInflater.from(getActivity()).inflate(R.layout.item_butten, null);
        View view4 = LayoutInflater.from(getActivity()).inflate(R.layout.item_rlv, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        ShowAdapter showAdapter = new ShowAdapter(getActivity(), list);
        rlv.setAdapter(showAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show;
    }
}