package com.example.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyInterface;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;
import com.example.lianxi4.R;
import com.example.presenter.MyPersenter;

public class PaoziActivity extends AppCompatActivity  {


    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paozi);
        initView();
    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);

    }
}
