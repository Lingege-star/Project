package com.example.jpush_test.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jpush_test.MainActivity;
import com.example.jpush_test.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView rec_main;
    private ArrayList<Integer> ban;
    private ArrayList<View> list;
    private MainAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        initView();
    }

    private void initView() {
        rec_main = (RecyclerView) findViewById(R.id.rec_main);
        View view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item1, null);
        View view2 = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item2, null);
        View view3 = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item3, null);
        View view4 = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item4, null);
        View view5 = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item5, null);
        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rec_main.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        list.add(view);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        list.add(view5);
        adapter = new MainAdapter(this, list,ban);
        rec_main.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "dsada", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}