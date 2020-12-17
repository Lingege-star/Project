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
import com.example.zuo_03.modle.bean.ShiBean;
import com.example.zuo_03.paresrcte.Parsetcay;
import com.example.zuo_03.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShiFragment extends Fragment implements IView  {


    private RecyclerView rlv;
    private ArrayList<ShiBean.DataBeanX.DataBean.AuthorBean> beans;
    private ArrayList<ShiBean.DataBeanX.DataBean> list;
    private ShiAdapter shiAdapter;

    public ShiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shi, container, false);
        initView(view);
        Parsetcay parsetcay = new Parsetcay(this);
        parsetcay.start();
        return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        beans = new ArrayList<>();
        list = new ArrayList<>();
        shiAdapter = new ShiAdapter(getActivity(),beans,list);
        rlv.setAdapter(shiAdapter);
    }

    @Override
    public void ShowOK(Object obj) {
        if(obj instanceof ShiBean){
            ShiBean shiBean= (ShiBean) obj;
            List<ShiBean.DataBeanX.DataBean> data = shiBean.getData().getData();
            for (int i = 0; i <data.size() ; i++) {
                ShiBean.DataBeanX.DataBean.AuthorBean author = data.get(i).getAuthor();
                beans.add(author);
                shiAdapter.notifyDataSetChanged();
            }
        }
        if(obj instanceof ShiBean){
            ShiBean shiBean= (ShiBean) obj;
            List<ShiBean.DataBeanX.DataBean> data = shiBean.getData().getData();
            list.addAll(data);
            shiAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void ShowNO(String no) {

    }
}
