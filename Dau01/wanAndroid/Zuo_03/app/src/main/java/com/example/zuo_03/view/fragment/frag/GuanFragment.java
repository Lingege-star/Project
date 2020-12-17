package com.example.zuo_03.view.fragment.frag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.zuo_03.App;
import com.example.zuo_03.R;
import com.example.zuo_03.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanFragment extends Fragment {


    private RecyclerView rlv;
    private ArrayList<Student> list;
    private RlvAdapter rlvAdapter;

    public GuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guan, container, false);
        ininView(view);
        initData();
        return view;
    }

    private void initData() {
        list.clear();
        List<Student> students = App.daoSession.getStudentDao().loadAll();
        list.addAll(students);
        rlvAdapter.notifyDataSetChanged();
    }

    private void ininView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        rlvAdapter = new RlvAdapter(getContext(),list);
        rlv.setAdapter(rlvAdapter);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if(hidden==false){
            initData();
        }
    }
}
