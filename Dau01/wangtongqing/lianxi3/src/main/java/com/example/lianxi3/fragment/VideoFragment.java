package com.example.lianxi3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lianxi3.R;
import com.example.lianxi3.adapter.VideoAdapter;
import com.example.lianxi3.bean.VideoInfo;
import com.example.lianxi3.persenter.MyPersenter;
import com.example.lianxi3.view.MyView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment implements MyView<VideoInfo> {


    private ArrayList<VideoInfo.DataBeanX.DataBean> dataBeans;
    private MyPersenter myPersenter;
    private RecyclerView rcy;
    private String page="12";
    private String type="video";
    private VideoAdapter videoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        dataBeans = new ArrayList<>();
        myPersenter = new MyPersenter(this);
        rcy = view.findViewById(R.id.rcy);
        myPersenter.getVideo(page,type);
        return view;
    }

    @Override
    public void OnSuecss(VideoInfo videoInfo) {
            if (videoInfo!=null){
                dataBeans.addAll(videoInfo.getData().getData());
            }
        videoAdapter = new VideoAdapter(getContext(), dataBeans);
            rcy.setLayoutManager(new LinearLayoutManager(getContext()));
            rcy.setAdapter(videoAdapter);
            videoAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(String msg) {
        Log.e("TAG", "OnFaile: " +msg);
    }
}
