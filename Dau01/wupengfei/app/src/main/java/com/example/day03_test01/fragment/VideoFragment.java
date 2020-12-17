package com.example.day03_test01.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03_test01.R;
import com.example.day03_test01.adapter.VideoRcyAdapter;
import com.example.day03_test01.bean.VideoBean;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    private RecyclerView rv_recycler_video;
    private ArrayList<VideoBean.DataBeanX.DataBean> list;
    private VideoRcyAdapter videoRcyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_recycler_video = view.findViewById(R.id.rv_recycler_video);
        rv_recycler_video.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        videoRcyAdapter = new VideoRcyAdapter(getContext(),list);
        rv_recycler_video.setAdapter(videoRcyAdapter);
    }
}