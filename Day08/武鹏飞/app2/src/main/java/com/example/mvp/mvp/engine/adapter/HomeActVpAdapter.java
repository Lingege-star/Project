package com.example.mvp.mvp.engine.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mvp.base.App;

import java.util.List;

public class HomeActVpAdapter extends FragmentPagerAdapter {

    private  FragmentManager mManage;
    private  List<Fragment> mFragment;
    private  int[] mTabs;

    public HomeActVpAdapter(FragmentManager mManage, List<Fragment> fragment, int[] mTabs) {
        super(mManage);
        this.mFragment = fragment;
        this.mTabs = mTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //将int类型转换为String
        return  App.getStr(mTabs[position]);
    }
}
