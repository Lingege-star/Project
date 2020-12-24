package com.example.day08.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.MapView;
import com.example.day08.R;

public class DituActivity extends AppCompatActivity {
    private MapView mMapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ditu);
        initView();
    }

    private void initView() {
        mMapView = (MapView) findViewById(R.id.mMapView);
    }
}
