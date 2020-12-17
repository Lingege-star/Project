package com.example.lianxi3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxi3.R;
import com.example.lianxi3.adapter.LikeAdapter;
import com.example.lianxi3.bean.LikeInfo;
import com.example.lianxi3.persenter.MyPersenter;
import com.example.lianxi3.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends Fragment implements MyView<LikeInfo> {


    private RecyclerView rcy;
    private MyPersenter myPersenter;
    private ArrayList<LikeInfo.DataBeanX.DataBean> dataBeans;
    private LikeAdapter likeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_like, container, false);
        rcy = inflate.findViewById(R.id.rcy);
        dataBeans = new ArrayList<>();
        myPersenter = new MyPersenter(this);
        myPersenter.getLiKe();
        return inflate;
    }

    @Override
    public void OnSuecss(LikeInfo likeInfo) {
        if (likeInfo != null) {
            dataBeans.addAll(likeInfo.getData().getData());
        }
        likeAdapter = new LikeAdapter(getContext(), dataBeans);
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
        rcy.setAdapter(likeAdapter);
        likeAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {

    }
}
