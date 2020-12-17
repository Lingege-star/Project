package com.example.a1217lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1217lian.R;
import com.example.a1217lian.adapter.PicRecyAdapter;
import com.example.a1217lian.bean.PicBean;
import com.example.a1217lian.presenter.PicPresenter;
import com.example.a1217lian.view.PicView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicFragment extends Fragment implements PicView {


    private RecyclerView recy;
    private ArrayList<PicBean.DataBeanX.DataBean> list;
    private PicRecyAdapter picRecyAdapter;
    private PicPresenter picPresenter;

    public PicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pic, container, false);
        picPresenter = new PicPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        picPresenter.getPic();
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        picRecyAdapter = new PicRecyAdapter(getActivity(), list);
        recy.setAdapter(picRecyAdapter);
    }

    @Override
    public void onSuccess(PicBean picBean) {
        list.addAll(picBean.getData().getData());
        picRecyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String msg) {
        Log.e("TAG", msg);
    }
}
