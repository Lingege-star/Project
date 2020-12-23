package com.example.myapplication.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名:My Application
 * 包名:com.example.myapplication.ui
 * 创建者: WangTQ
 * 创建时间: 2020/12/23
 */
public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.bmapView)
    MapView bmapView;
    private BaiduMap mBaiduMap;
    private LocationClient locationClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        mBaiduMap = bmapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        locationClient = new LocationClient(this);

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        locationClient.setLocOption(option);

//注册LocationListener监听器
        BaiDuLinsener myLocationListener = new BaiDuLinsener();
        locationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        locationClient.start();
        mBaiduMap.setMyLocationEnabled(true);

    }
    class BaiDuLinsener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
//mapView 销毁后不在处理新接收的位置
            if (bdLocation == null || bmapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(bdLocation.getDirection()).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
        }

    }


















    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        bmapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        bmapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        bmapView.onDestroy();
        bmapView = null;
        super.onDestroy();
    }
}
