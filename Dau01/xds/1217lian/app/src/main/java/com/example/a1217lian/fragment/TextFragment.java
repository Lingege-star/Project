package com.example.a1217lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.a1217lian.R;
import com.example.a1217lian.adapter.TextRecyAdapter;
import com.example.a1217lian.bean.TextBean;
import com.example.a1217lian.presenter.TextPresenter;
import com.example.a1217lian.view.TextView;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment implements TextView {


    private RecyclerView recy;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private TextRecyAdapter textRecyAdapter;
    private TextPresenter textPresenter;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textPresenter = new TextPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        textPresenter.getData();
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        textRecyAdapter = new TextRecyAdapter(getActivity(),list);
        recy.setAdapter(textRecyAdapter);
    }

    @Override
    public void onSuccess(TextBean textBean) {
        list.addAll(textBean.getData().getData());
        textRecyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFile(String msg) {

    }
}
