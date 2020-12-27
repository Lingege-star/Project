package com.example.day09;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.example.day09.overlayutil.WalkingRouteOverlay;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText cheng1;
    private EditText di1;
    private LinearLayout input_search;
    private EditText cheng2;
    private EditText di2;
    private Button ok;
    private MapView map;
    private String di2String;
    private String cheng2String;
    private String di1String;
    private String cheng1String;
    private BaiduMap mBaiduMap;
    private Unbinder mBind;
    private OnGetRoutePlanResultListener listener;
    private RoutePlanSearch mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = RoutePlanSearch.newInstance();

        initView();
        initData();
    }

    private void initData() {
        listener = new OnGetRoutePlanResultListener() {
            @Override
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
                //创建WalkingRouteOverlay实例
                WalkingRouteOverlay overlay = new WalkingRouteOverlay(mBaiduMap);
                if (walkingRouteResult.getRouteLines() != null) {
                    if (walkingRouteResult.getRouteLines().size() > 0) {
                        //获取路径规划数据,(以返回的第一条数据为例)
                        //为WalkingRouteOverlay实例设置路径数据
                        overlay.setData(walkingRouteResult.getRouteLines().get(0));
                        //在地图上绘制WalkingRouteOverlay
                        overlay.addToMap();
                    }
                }
            }

            @Override
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

            }

            @Override
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

            }

            @Override
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {

            }

            @Override
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

            }

            @Override
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

            }

        };
    }

    private void initView() {
        cheng1 = (EditText) findViewById(R.id.cheng1);
        di1 = (EditText) findViewById(R.id.di1);
        input_search = (LinearLayout) findViewById(R.id.input_search);
        cheng2 = (EditText) findViewById(R.id.cheng2);
        di2 = (EditText) findViewById(R.id.di2);
        ok = (Button) findViewById(R.id.ok);
        map = (MapView) findViewById(R.id.map);
        mBind = ButterKnife.bind(this);
        mBaiduMap = map.getMap();
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok:
                mSearch.setOnGetRoutePlanResultListener(listener);
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        cheng1String = cheng1.getText().toString().trim();
        if (TextUtils.isEmpty(cheng1String)) {
            Toast.makeText(this, "cheng1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        di1String = di1.getText().toString().trim();
        if (TextUtils.isEmpty(di1String)) {
            Toast.makeText(this, "di1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        cheng2String = cheng2.getText().toString().trim();
        if (TextUtils.isEmpty(cheng2String)) {
            Toast.makeText(this, "cheng2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        di2String = di2.getText().toString().trim();
        if (TextUtils.isEmpty(di2String)) {
            Toast.makeText(this, "di2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if(!TextUtils.isEmpty(cheng1String)
                &&!TextUtils.isEmpty(cheng2String)
                &&!TextUtils.isEmpty(di1String)
                &&!TextUtils.isEmpty(di2String)){
            PlanNode stNode = PlanNode.withCityNameAndPlaceName(cheng1String, di1String);
            PlanNode enNode = PlanNode.withCityNameAndPlaceName(cheng2String, di2String);
            mSearch.walkingSearch((new WalkingRoutePlanOption())
                    .from(stNode)
                    .to(enNode));
        }else {
            Toast.makeText(this, "内容不可为空", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
    }
}
