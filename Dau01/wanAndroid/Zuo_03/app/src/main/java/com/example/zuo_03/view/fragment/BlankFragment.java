package com.example.zuo_03.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.zuo_03.R;
import com.example.zuo_03.view.fragment.frag.ImageFragment;
import com.example.zuo_03.view.fragment.frag.ShiFragment;
import com.example.zuo_03.view.fragment.frag.TextFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private ViewPager vp;
    private TabLayout tab;
    private VpAdapter vpAdapter;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        vp = view.findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new ImageFragment());
        list.add(new ShiFragment());
        list.add(new TextFragment());
        vpAdapter = new VpAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        vp.setAdapter(vpAdapter);
        tab = view.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }

}
