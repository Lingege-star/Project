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
import com.example.zuo_03.view.fragment.frag.GuanFragment;
import com.example.zuo_03.view.fragment.frag.TuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private ViewPager vp;
    private TabLayout tab;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        ininView(view);
        return view;
    }

    private void ininView(View view) {
        vp = view.findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new GuanFragment());
        list.add(new TuFragment());
        HomeAdapter homeAdapter = new HomeAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        vp.setAdapter(homeAdapter);
        tab = view.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("关注");
        tab.getTabAt(1).setText("推荐");
    }

}
