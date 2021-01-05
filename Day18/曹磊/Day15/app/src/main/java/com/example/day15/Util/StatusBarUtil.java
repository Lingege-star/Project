package com.example.day15.Util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.day15.ui.ShowActivity;

public class StatusBarUtil {
    public static void setStatusBarColor(Activity context,int colorRes){
        Window window = context.getWindow();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            //添加状态栏背景色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(context.getResources().getColor(colorRes));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static void setStatusBarTrans(Activity context) {
        Window window = context.getWindow();
        window.getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setNavigationBarColor(Color.TRANSPARENT);
    }
}
