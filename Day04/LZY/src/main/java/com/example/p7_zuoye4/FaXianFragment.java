package com.example.p7_zuoye4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FaXianFragment extends Fragment {

    private View view;
    private ViewPager vp_fx;
    private TabLayout tl_fx;
    private ArrayList<Fragment> list;
    private MainVpAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fa_xian, container, false);
        initView();
        return view;
    }

    private void initView() {
        tl_fx = view.findViewById(R.id.tl_fx);
        vp_fx = view.findViewById(R.id.vp_fx);
        list = new ArrayList<>();
        list.add(new HotFragment());
        list.add(new ZhuangZaoFragment());
        list.add(new TuShangFragment());
        list.add(new BaiKeFragment());
        adapter = new MainVpAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        vp_fx.setAdapter(adapter);
        tl_fx.setupWithViewPager(vp_fx);
        tl_fx.getTabAt(0).setText("热点");
        tl_fx.getTabAt(1).setText("妆造");
        tl_fx.getTabAt(2).setText("图赏");
        tl_fx.getTabAt(3).setText("百科");
    }
}