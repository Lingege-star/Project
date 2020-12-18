package com.example.Day02.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.Day02.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private RecyclerView rlv;
    private TabLayout tab;
    private ArrayList<View> list;
    private MyAdapter myAdapter;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_faxian, null);
        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.item_remeng, null);
        View view3 = LayoutInflater.from(getActivity()).inflate(R.layout.item_vip, null);
        list = new ArrayList<>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        myAdapter = new MyAdapter(getActivity(),list);
        rlv.setAdapter(myAdapter);
    }

}
