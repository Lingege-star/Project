package com.example.day15.ui.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day15.R;
import com.example.day15.map.base.App;
import com.example.day15.map.base.BaseFragment;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.model.bean.XuanBean;
import com.example.day15.presenter.SelCourseActPresenter;
import com.example.day15.ui.SelCourseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class XuanFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.but_ok)
    Button but_Ok;

    @Override
    protected BasePresenter createPresenter() {
        return new SelCourseActPresenter(this);
    }

    @Override
    protected void init() {
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onScuccess(Object o) {
        super.onScuccess(o);

        if(o instanceof XuanBean){
            XuanBean xuanBean= (XuanBean) o;
            List<List<XuanBean.DataBean>> data = xuanBean.getData();

            SelCourseAdapter selCourseAdapter = new SelCourseAdapter(data);
            rlv.setAdapter(selCourseAdapter);
        }

        Log.e("TAG","请求成功");
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
        Log.e("TAG","失败了哇"+msg);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xuan;
    }
}