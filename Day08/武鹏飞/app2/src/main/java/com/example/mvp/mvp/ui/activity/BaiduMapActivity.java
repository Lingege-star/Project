package com.example.mvp.mvp.ui.activity;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.MapView;
import com.example.mvp.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

public class BaiduMapActivity extends AppCompatActivity {
    private MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baidu_map_activity);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        initPermission();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    //获取权限
    private void initPermission() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override//有权限
            public void permissionGranted(@NonNull String[] strings) {

            }

            @Override//没有权限
            public void permissionDenied(@NonNull String[] strings) {

            }
        }, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }}
