package com.example.a1218lian.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a1218lian.R;
import com.example.a1218lian.adapter.MainVpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private MainVpAdapter mainVpAdapter;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = view.findViewById(R.id.tab);
        vp = view.findViewById(R.id.vp);
        list = new ArrayList<>();
        list.add(new GuanZhuFragment());
        list.add(new TuiJianFragment());

        mainVpAdapter = new MainVpAdapter(getChildFragmentManager(), list);
        vp.setAdapter(mainVpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("关注");
        tab.getTabAt(1).setText("推荐");
    }

}
