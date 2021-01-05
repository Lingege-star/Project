package com.example.day15.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.annotation.GlideOption;
import com.example.day15.R;
import com.example.day15.map.Manager.ContainManager;
import com.example.day15.map.Manager.ThreadPoolManager;
import com.example.day15.map.base.App;
import com.example.day15.map.base.BaseActivity;
import com.example.day15.map.base.BasePresenter;
import com.example.day15.map.model.bean.LingBean;
import com.example.day15.map.model.constants.ApiConstants;
import com.example.day15.presenter.SplashPresenter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    private boolean TUICHU;
    private Handler handler=new Handler();

    @Override
    protected BasePresenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void init() {

        ContainManager.getManager().save_boolean("ck",true);
        vp = (ViewPager) findViewById(R.id.vp);
        ArrayList<View> list = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.item_v1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.item_v2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.item_v3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        TextView tv = view3.findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SelCourseActivity.class));
            }
        });
        VpAdapter vpAdapter = new VpAdapter(list);
        vp.setAdapter(vpAdapter);


    }



    @Override
    protected void click(View view) {

    }

    @Override
    protected int getlayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onScuccess(Object o) {
        super.onScuccess(o);
        if(o instanceof LingBean){
            LingBean bean= (LingBean) o;
            String data = bean.getData();
            ContainManager.getManager().seve_str("decode",data);
            Log.e("TAG","请求成功"+data);
        }
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!TUICHU) {
                TUICHU = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TUICHU = false;
                    }
                }, 2000);
            } else {
                ContainManager.getManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

