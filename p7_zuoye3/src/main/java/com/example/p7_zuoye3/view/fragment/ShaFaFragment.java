package com.example.p7_zuoye3.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.model.adapter.ShaFaVpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ShaFaFragment extends Fragment {

    private View view;
    private TabLayout tl_sha_fa;
    private ViewPager vp_sha_fa;
    private ArrayList<Fragment> list;
    private ShaFaVpAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sha_fa, container, false);
        initView();
        return view;
    }

    private void initView() {
        tl_sha_fa = view.findViewById(R.id.tl_sha_fa);
        vp_sha_fa = view.findViewById(R.id.vp_sha_fa);
        list = new ArrayList<>();
        list.add(new TuPianFragment());
        list.add(new MovieFragment());
        list.add(new TextFragment());
        adapter = new ShaFaVpAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        vp_sha_fa.setAdapter(adapter);
        tl_sha_fa.setupWithViewPager(vp_sha_fa);
        tl_sha_fa.getTabAt(0).setText("图片");
        tl_sha_fa.getTabAt(1).setText("视频");
        tl_sha_fa.getTabAt(2).setText("文本");
    }
}