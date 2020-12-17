package com.example.a1217lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.a1217lian.R;
import com.example.a1217lian.adapter.ViewRecyAdapter;
import com.example.a1217lian.bean.ViewBean;
import com.example.a1217lian.presenter.ViewPresenter;
import com.example.a1217lian.view.ViewView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment implements ViewView {


    private RecyclerView recy;
    private ArrayList<ViewBean.DataBeanX.DataBean> list;
    private ViewRecyAdapter viewRecyAdapter;
    private ViewPresenter viewPresenter;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        viewPresenter = new ViewPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        viewPresenter.getData();
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        viewRecyAdapter = new ViewRecyAdapter(getActivity(),list);
        recy.setAdapter(viewRecyAdapter);
    }

    @Override
    public void onSuccess(ViewBean viewBean) {
        list.addAll(viewBean.getData().getData());
        viewRecyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String msg) {

    }
}
