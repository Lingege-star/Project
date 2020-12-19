package com.example.pingmu;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity  {

    private RelativeLayout relaHeader;
    private TextView tvTitle;
    private ImageView ivShow;
    private Banner banner;
    private TextView showChu;
    private LinearLayout showLl;
    private RecyclerView recycler;
    private TabLayout tab;
    private Button butMin;
    private Button nutFan;
    private ArrayList<Integer> pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        relaHeader = (RelativeLayout) findViewById(R.id.rela_header);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivShow = (ImageView) findViewById(R.id.iv_show);
        banner = (Banner) findViewById(R.id.banner);
        showChu = (TextView) findViewById(R.id.show_chu);
        showLl = (LinearLayout) findViewById(R.id.show_ll);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        tab = (TabLayout) findViewById(R.id.tab);
        butMin = (Button) findViewById(R.id.but_min);
        nutFan = (Button) findViewById(R.id.but_fan);


        pic = new ArrayList<>();
        pic.add(R.mipmap.a);
        pic.add(R.mipmap.b);
        pic.add(R.mipmap.c);
        pic.add(R.mipmap.d);
        pic.add(R.mipmap.e);


        banner.setImages(pic).start();


        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Bean> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Bean("张安"+i,10+i,"男"));

        }
        RlvAdapter adapter = new RlvAdapter(list, this);
        recycler.setAdapter(adapter);


    }

}



