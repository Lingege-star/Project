package com.example.day05_test_01.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day05_test_01.R;
import com.example.day05_test_01.adapter.RcyAdapter;
import com.example.day05_test_01.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rv_recycler_home;
    private SearchView sv_search_home;
    private RcyAdapter rcyAdapter;
    private ArrayList<Bean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            list.add(new Bean("a",R.drawable.a01));
        }
        rcyAdapter.notifyDataSetChanged();

    }

    private void initView(View view) {
        rv_recycler_home = view.findViewById(R.id.rv_recycler_home);
        sv_search_home = view.findViewById(R.id.sv_search_home);

        rv_recycler_home.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        rcyAdapter = new RcyAdapter(getContext(), list);
        rv_recycler_home.setAdapter(rcyAdapter);
    }
}