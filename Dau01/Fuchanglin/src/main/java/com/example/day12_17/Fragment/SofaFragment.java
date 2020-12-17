package com.example.day12_17.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.day12_17.Adapter.Vpadapter;
import com.example.day12_17.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SofaFragment extends Fragment {

    private TabLayout tabSofa;
    private ViewPager vpsofa;
    private MoreFragment moreFragment;
    private MyFragment myFragment;
    private ShowFragment showFragment;

    public SofaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabSofa = (TabLayout) view.findViewById(R.id.tab_sofa);
        vpsofa = (ViewPager) view.findViewById(R.id.vp_sofa);

//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        moreFragment = new MoreFragment();
        myFragment = new MyFragment();
        showFragment = new ShowFragment();
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.vp_sofa, moreFragment)
//                .add(R.id.vp_sofa, moreFragment)
//                .add(R.id.vp_sofa, showFragment)
//                .show(moreFragment)
//                .hide(showFragment)
//                .commit();
//        tabSofa.addTab(tabSofa.newTab().setText("图片"));
//        tabSofa.addTab(tabSofa.newTab().setText("视频"));
//        tabSofa.addTab(tabSofa.newTab().setText("文本"));
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(moreFragment);
        list.add(myFragment);
        list.add(showFragment);
        ArrayList<String> title = new ArrayList<>();
        title.add("图片");
        title.add("视频");
        title.add("文本");
        Vpadapter vpadapter = new Vpadapter(getFragmentManager(), title, list);
        vpsofa.setAdapter(vpadapter);
        tabSofa.setupWithViewPager(vpsofa);
    }
}
