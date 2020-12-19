package com.example.Day05;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_sou;
    private RecyclerView rlv;
    private ArrayList<View> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_banner, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
//        View view3 = LayoutInflater.from(this).inflate(R.layout.item_dabang, null);
        list.add(view1);
        list.add(view2);
//        list.add(view3);
        myAdapter.notifyDataSetChanged();
    }

    private void initView() {
        et_sou = (EditText) findViewById(R.id.et_sou);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        rlv.setAdapter(myAdapter);

    }

    private void submit() {
        // validate
        String sou = et_sou.getText().toString().trim();
        if (TextUtils.isEmpty(sou)) {
            Toast.makeText(this, "搜索平台诗人名字、诗歌关键词", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
