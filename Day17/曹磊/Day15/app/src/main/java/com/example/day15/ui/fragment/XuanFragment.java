package com.example.day15.ui.fragment;

import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.BaseFragment;
import com.example.day15.map.base.BasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class XuanFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.but_ok)
    Button but_Ok;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));


        CourseAdapter courseAdapter = new CourseAdapter();
        rlv.setAdapter(courseAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xuan;
    }
}