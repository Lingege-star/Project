package com.example.day15.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day15.R;
import com.example.day15.map.Manager.ContainManager;
import com.example.day15.map.Manager.ThreadPoolManager;
import com.example.day15.map.base.App;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
                .executeTimerTask(new Runnable() {
                    @Override
                    public void run() {
                        boolean ck = ContainManager.getManager().get_boolean("ck");
                        Intent intent=null;
                        if(!ck){
                            intent = new Intent(App.context(), HomeActivity.class);

                        }else {

                            intent=new Intent(App.context(),SelCourseActivity.class);
                        }
                        startActivity(intent);
                        finish();
                    }
                },2, TimeUnit.SECONDS);
//        getmPresenter().start(ApiConstants.DEVICE);
    }
}