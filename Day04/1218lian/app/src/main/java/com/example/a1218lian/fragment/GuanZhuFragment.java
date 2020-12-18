package com.example.a1218lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.a1218lian.BaseApp;
import com.example.a1218lian.R;
import com.example.a1218lian.adapter.TuiJianAdapter;
import com.example.a1218lian.bean.DataBean;
import com.example.a1218lian.presenter.TuiPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanZhuFragment extends Fragment {

    private RecyclerView recy;
    private ArrayList<DataBean> list;
    private TuiJianAdapter tuiJianAdapter;
    private TuiPresenter tuiPresenter;

    public GuanZhuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guan_zhu, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        List<DataBean> beanList = BaseApp.getInstance().getDaoSession().getDataBeanDao().queryBuilder().list();
        list.addAll(beanList);
        tuiJianAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        tuiJianAdapter = new TuiJianAdapter(getActivity(), list);
        recy.setAdapter(tuiJianAdapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && list != null) {
            list.clear();
            tuiJianAdapter.notifyDataSetChanged();
            initData();
        }
    }
}
