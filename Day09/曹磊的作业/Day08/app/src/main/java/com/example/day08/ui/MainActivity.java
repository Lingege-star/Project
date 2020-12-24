package com.example.day08.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day08.R;
import com.example.day08.map.base.BaseActivity;
import com.example.day08.map.base.BasePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<View> list;
    private RlvAdapter rlvAdapter;

    @Override
    protected void init() {
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        rlvAdapter = new RlvAdapter(this,list);
        rlv.setAdapter(rlvAdapter);
    }

    @Override
    protected void initData() {
        super.initData();


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected void click(View view) {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_tab, null);
        list.add(view1);
        rlvAdapter.notifyDataSetChanged();
    }
}
