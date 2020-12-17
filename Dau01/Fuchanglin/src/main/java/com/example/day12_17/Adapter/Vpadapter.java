package com.example.day12_17.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Vpadapter extends FragmentPagerAdapter {
    private final ArrayList<String> title;
    private final ArrayList<Fragment> fragments;

    public Vpadapter(@NonNull FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> fragments) {
        super(fm);
        this.title = title;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
