package com.example.p7_zuoye5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<View> list = new ArrayList<>();
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item1, null);
        View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item2, null);
        View view3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item3, null);
        list.add(view);
        list.add(view2);
        list.add(view3);
        RecAdapter adapter = new RecAdapter(this,list);
        rv_main.setAdapter(adapter);
    }
}
