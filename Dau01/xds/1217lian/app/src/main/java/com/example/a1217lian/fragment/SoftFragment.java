package com.example.a1217lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1217lian.R;
import com.example.a1217lian.adapter.MainVpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoftFragment extends Fragment {


    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private MainVpAdapter mainVpAdapter;

    public SoftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soft, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);
        list = new ArrayList<>();
        list.add(new PicFragment());
        list.add(new ViewFragment());
        list.add(new TextFragment());

        mainVpAdapter = new MainVpAdapter(getChildFragmentManager(), list);
        vp.setAdapter(mainVpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }

}
