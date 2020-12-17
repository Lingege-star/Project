package com.example.day12_17.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day12_17.Adapter.VidApadter;
import com.example.day12_17.Bean.VideoBean;
import com.example.day12_17.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private RecyclerView rec;
    private ArrayList<VideoBean> videoBeans;
    private VidApadter apadter;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rec = (RecyclerView) view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoBeans = new ArrayList<>();
        apadter = new VidApadter(getContext(),videoBeans);
        rec.setAdapter(apadter);
    }
}
