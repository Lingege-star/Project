package com.example.a1217lian.fragment;


import android.graphics.YuvImage;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a1217lian.BaseApp;
import com.example.a1217lian.R;
import com.example.a1217lian.adapter.TuiJianAdapter;
import com.example.a1217lian.bean.DataBean;
import com.example.a1217lian.bean.TuiJianBean;
import com.example.a1217lian.presenter.TuiPresenter;
import com.example.a1217lian.view.TuiView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiJianFragment extends Fragment implements TuiView {


    private RecyclerView recy;
    private ArrayList<DataBean> list;
    private TuiJianAdapter tuiJianAdapter;
    private TuiPresenter tuiPresenter;

    public TuiJianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tui_jian, container, false);
        tuiPresenter = new TuiPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        tuiPresenter.getData();
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        tuiJianAdapter = new TuiJianAdapter(getActivity(),list);
        recy.setAdapter(tuiJianAdapter);

        tuiJianAdapter.setOnItemClickListener(new TuiJianAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                BaseApp.getInstance().getDaoSession().getDataBeanDao().insertOrReplace(list.get(position));
                Toast.makeText(getActivity(), "关注成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccess(TuiJianBean tuiJianBean) {
        list.addAll(tuiJianBean.getData().getData());
        tuiJianAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String msg) {

    }
}
