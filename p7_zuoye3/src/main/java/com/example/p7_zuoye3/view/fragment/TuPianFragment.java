package com.example.p7_zuoye3.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.model.adapter.TuPianRecAdapter;
import com.example.p7_zuoye3.model.bean.TuPianBean;
import com.example.p7_zuoye3.perster.TuPianRecperster;
import com.example.p7_zuoye3.view.IView;

import java.util.ArrayList;
import java.util.List;

public class TuPianFragment extends Fragment implements IView {

    private View view;
    private RecyclerView rv_tp;
    private ArrayList<TuPianBean.DataBeanX.DataBean> list;
    private TuPianRecAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tu_pian, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        TuPianRecperster recperster = new TuPianRecperster(this);
        recperster.start();
    }

    private void initView() {
        rv_tp = view.findViewById(R.id.rv_tp);
        rv_tp.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new TuPianRecAdapter(getActivity(), list);
        rv_tp.setAdapter(adapter);
    }

    @Override
    public void OKHottp(Object obj) {
        if(obj instanceof TuPianBean){
            TuPianBean obj1 = (TuPianBean) obj;
            List<TuPianBean.DataBeanX.DataBean> data = obj1.getData().getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void NOHottp(String msg) {
        Toast.makeText(getActivity(), "请求失败"+msg, Toast.LENGTH_SHORT).show();
    }
}