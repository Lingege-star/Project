package com.example.fuchanglin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fuchanglin.Activity.TongPaoActivity;
import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView aq;
    private TextView btnTime;
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        countDowntime();
    }

    @SuppressLint("CheckResult")
    private void countDowntime() {
        subscribe = Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        long l = 5 - aLong;
                        btnTime.setText(l + " 跳转");
                        if (l == 0) {
                            startActivity(new Intent(MainActivity.this, TongPaoActivity.class));
                            finish();
                        }
                    }
                });
    }

    private void initView() {


        aq = (ImageView) findViewById(R.id.aq);
        btnTime = (TextView) findViewById(R.id.btn_time);

        btnTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        subscribe.dispose();
        startActivity(new Intent(MainActivity.this, TongPaoActivity.class));
        finish();
    }
}
