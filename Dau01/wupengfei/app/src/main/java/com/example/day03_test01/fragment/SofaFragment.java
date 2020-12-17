package com.example.day03_test01.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03_test01.R;
import com.example.day03_test01.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SofaFragment extends Fragment {

    private TabLayout tl_tabLayout_sofa;
    private ViewPager vp_viewPager_sofa;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private VpAdapter vpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        tl_tabLayout_sofa = view.findViewById(R.id.tl_tabLayout_sofa);
        vp_viewPager_sofa = view.findViewById(R.id.vp_viewPager_sofa);
        fragments = new ArrayList<>();
        fragments.add(new PicFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());

        titles = new ArrayList<>();
        titles.add("图片");
        titles.add("视频");
        titles.add("文本");

        vpAdapter = new VpAdapter(getFragmentManager(), fragments, titles);
        vp_viewPager_sofa.setAdapter(vpAdapter);
        tl_tabLayout_sofa.setupWithViewPager(vp_viewPager_sofa);
    }
}