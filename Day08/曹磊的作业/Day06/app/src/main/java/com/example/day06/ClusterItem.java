package com.example.day06;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;

public interface ClusterItem {
    LatLng getPosition();
    BitmapDescriptor getBitmapDescriptor();
}
