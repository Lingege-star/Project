package com.example.lianxi3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxi3.R;
import com.example.lianxi3.adapter.TextAdapter;
import com.example.lianxi3.bean.TextInfo;
import com.example.lianxi3.persenter.MyPersenter;
import com.example.lianxi3.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment implements MyView<TextInfo> {


    private ArrayList<TextInfo.DataBeanX.DataBean> dataBeans;
    private RecyclerView rcy;
    private MyPersenter myPersenter;
    private String page = "12";
    private String type = "text";
    private TextAdapter textAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_text, container, false);
        dataBeans = new ArrayList<>();
        myPersenter = new MyPersenter(this);
        rcy = inflate.findViewById(R.id.rcy);
        myPersenter.getText(page, type);
        return inflate;
    }

    @Override
    public void OnSuecss(TextInfo textInfo) {
        if (textInfo != null) {
            dataBeans.addAll(textInfo.getData().getData());
        }
        textAdapter = new TextAdapter(getContext(), dataBeans);
        rcy.setLayoutManager(new LinearLayoutManager(getContext()));
        rcy.setAdapter(textAdapter);
        textAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnFaile(String msg) {
        Log.e("TAG", "OnFaile: " + msg);
    }
}
