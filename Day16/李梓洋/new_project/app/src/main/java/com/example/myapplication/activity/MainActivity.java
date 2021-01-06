package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mvplibrary.base.App;
import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.manager.ContainManager;
import com.example.myapplication.R;
import com.example.myapplication.StatusBarUtil;
import com.example.myapplication.fragment.CourseFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.MineFragment;
import com.example.myapplication.fragment.LearnFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.fra)
    FrameLayout lin;
    @BindView(R.id.act_nav)
    BottomNavigationView mActNav;

    private boolean mIsExit;
    private Handler mHandler = new Handler();
    private Fragment[] fragments = new Fragment[4];

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        StatusBarUtil.setStatusBarTrans(this);
        mActNav.setItemIconTintList(null);

        //让第0个tab默认选中
        mActNav.setSelectedItemId(R.id.nav_home);

        //让x个tab默认选中
       // mActNav.setSelectedItemId(mActNav.getMenu().getItem(0).getItemId());
        fragments[0] = new HomeFragment();
        fragments[1] = new CourseFragment();
        fragments[2] = new LearnFragment();
        fragments[3] = new MineFragment();

        initListener();

        //将4个fragment对象添加到FragmentManager管理器中，默认显示第0个fragment
        initLoadFragment(R.id.fra,0);

    }

    private void initLoadFragment(int containId, int tabPosition) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            ft.add(containId,fragments[i],fragments[i].getClass().getSimpleName());
            if (i != tabPosition)
                ft.hide(fragments[i]);
        }
        ft.commitNowAllowingStateLoss();//提交事物时避免FragmentManager出现异常
    }

    private void initListener() {
        mActNav.setOnNavigationItemSelectedListener(itemSelectedListener);
    }


    private int mFragFlag;
    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = item -> {
        switch (item.getItemId()){
            case R.id.nav_home:
                switchFragment (fragments[0],fragments[mFragFlag]);
                mFragFlag = 0;
                break;
            case R.id.nav_course:
                switchFragment (fragments[1],fragments[mFragFlag]);
                mFragFlag = 1;
                break;
            case R.id.nav_learn:
                switchFragment (fragments[2],fragments[mFragFlag]);
                mFragFlag = 2;
                break;
            case R.id.nav_mine:
                switchFragment (fragments[3],fragments[mFragFlag]);
                mFragFlag = 3;
                break;
        }
      return true;
    };

    private void switchFragment(Fragment showFragment, Fragment hintFragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (showFragment != hintFragment)
            ft.hide(hintFragment).show(showFragment);
        ft.commitNowAllowingStateLoss();
    }


    @Override
    protected void click(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //TODO  2秒内连续点击两次 退出程序，  如果第二次点击超过2秒了，会Toast提示再按一次退出程序
            if (!mIsExit) {
                mIsExit = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_LONG).show();
                //2秒之后把变量值改成true
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            } else {
                ContainManager.getmManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}