package com.example.day15.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.BaseFragment;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.ui.ShowAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<View> list = new ArrayList<>();
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_banner, null);
        list.add(view1);
        ShowAdapter showAdapter = new ShowAdapter(getActivity(), list);
        rlv.setAdapter(showAdapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show;
    }
}