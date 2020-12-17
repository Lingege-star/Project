package com.example.lianxi3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxi3.adapter.PicAdapter;
import com.example.lianxi3.bean.PicInfo;
import com.example.lianxi3.R;
import com.example.lianxi3.persenter.MyPersenter;
import com.example.lianxi3.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicsFragment extends Fragment implements MyView<PicInfo> {


    private RecyclerView rcy;
    private MyPersenter myPersenter;
    private ArrayList<PicInfo.DataBeanX.DataBean> dataBeans;
    private PicAdapter picAdapter;

    private String page="12";
    private String type="pics";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pics, container, false);
        dataBeans = new ArrayList<>();
        myPersenter = new MyPersenter(this);
        rcy = view.findViewById(R.id.rcy);
        myPersenter.getPic(page,type);
        return view;
    }

    @Override
    public void OnSuecss(PicInfo picInfo) {
            if (picInfo!=null){
                dataBeans.addAll(picInfo.getData().getData());
            }
        picAdapter = new PicAdapter(getContext(), dataBeans);
            rcy.setLayoutManager(new LinearLayoutManager(getContext()));
            rcy.setAdapter(picAdapter);
            picAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e("TAG", "OnFaile: " +msg);
    }
}
