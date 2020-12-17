package com.example.lianxi3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxi3.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<Fragment> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_data, container, false);
        initView(inflate);
        return inflate;
    }

    String[] arr = {"图片", "视频", "文本"};

    private void initView(View inflate) {
        tab = inflate.findViewById(R.id.tablayout);
        pager = inflate.findViewById(R.id.pager);
        list = new ArrayList<>();
        list.add(new PicsFragment());
        list.add(new VideoFragment());
        list.add(new TextFragment());
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
