package com.example.lianxi3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lianxi3.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<Fragment> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        initView(view);
        return view;
    }
    String[] arr = {"关注", "推荐"};
    private void initView(View view) {
        tab = view.findViewById(R.id.tablayout);
        pager = view.findViewById(R.id.pager);
        list = new ArrayList<>();
        list.add(new ItemFragment());
        list.add(new LikeFragment());
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return arr[position];
            }
        });
        tab.setupWithViewPager(pager);
    }
}
