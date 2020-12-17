package com.example.zuo_03.view.fragment.frag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.zuo_03.R;
import com.example.zuo_03.modle.bean.TuBean;
import com.example.zuo_03.paresrcte.Parsetcay;
import com.example.zuo_03.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuFragment extends Fragment implements IView {


    private RecyclerView rlv;
    private ArrayList<TuBean.DataBeanX.DataBean> list;
    private MyAdapter myAdapter;

    public TuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tu, container, false);
        initView(view);
        Parsetcay parsetcay = new Parsetcay(this);
        parsetcay.start();
        return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(getContext(),list);
        rlv.setAdapter(myAdapter);
    }

    @Override
    public void ShowOK(Object obj) {
        if(obj instanceof TuBean){
            TuBean tuBean= (TuBean) obj;
            List<TuBean.DataBeanX.DataBean> data = tuBean.getData().getData();
            list.addAll(data);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void ShowNO(String no) {

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
