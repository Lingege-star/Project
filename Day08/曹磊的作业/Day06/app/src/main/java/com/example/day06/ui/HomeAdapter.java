package com.example.day06.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day06.map.base.App;

import java.util.ArrayList;

class HomeAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private int[] mTabs;

    public HomeAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list, int[] mTabs) {
        super(fm);
        this.list = list;
        this.mTabs = mTabs;
    }

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
        return App.getStr(mTabs[position]);
    }


}
