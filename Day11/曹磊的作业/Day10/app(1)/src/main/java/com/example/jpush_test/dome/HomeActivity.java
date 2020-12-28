package com.example.jpush_test.dome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpush_test.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<View> list = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_0, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_1, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_2, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.item_3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        RlvAdapter rlvAdapter = new RlvAdapter(this,list);
        rlv.setAdapter(rlvAdapter);
    }
}
