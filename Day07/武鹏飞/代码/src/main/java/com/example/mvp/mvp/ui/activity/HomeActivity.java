package com.example.mvp.mvp.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.mvp.R;
import com.example.mvp.base.App;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.manager.ContainManager;
import com.example.mvp.manager.ThreadPoolManager;
import com.example.mvp.mvp.engine.adapter.HomeActVpAdapter;
import com.example.mvp.mvp.ui.fragment.CollectFragment;
import com.example.mvp.mvp.ui.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

//继承创建的activity的基类，抽象方法需要重写
public abstract class HomeActivity extends BaseActivity {
    //通过ButterKnife创建控件
    @BindView(R.id.home_act_vp)
    ViewPager mHomeActVp;
    @BindView(R.id.home_act_tab)
    TabLayout mHomeActTab;



    //退出activity的判断值，默认false
    private boolean mIsExit;
    private FragmentManager mManage;
    //tabLayout标题，使用常量，不要出现中文
    private int[] mTabs = {R.string.home_tab_title,R.string.collect_tab_title};

    @Override//初始化的方法
    protected void init() {
        mManage = getSupportFragmentManager();
        HomeActVpAdapter homeActVpAdapter = new HomeActVpAdapter(mManage,getFragment(),mTabs);
        mHomeActVp.setAdapter(homeActVpAdapter);
        mHomeActTab.setupWithViewPager(mHomeActVp);
    }
    //添加fragment
    private List<Fragment> getFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CollectFragment());
        return fragments;
    }

    @Override
    protected void initData() {
        //断开网络开关
        Observable.just(1, 2).subscribe(new Observer<Integer>() {
            @Override//控制网络开关对象Disposable
            public void onSubscribe(Disposable d) {
                //V层退出时，P层可能还在请求数据，V层退出后，将网络请求关闭
            }

            @Override//成功的方法
            public void onNext(Integer integer) {
            }

            @Override//失败的方法
            public void onError(Throwable e) {
            }

            @Override//已经完成的方法
            public void onComplete() {
            }
        });
    }



    @Override//加载布局的方法
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    //监听返回键的方法
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }

    //监听键盘码，按返回键退出程序，在HomeActivity中实现，在基类中实现的话每一个继承基类的activity都有这个方法
    @Override//keyCode 键盘码
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //键盘码为返回键，按返回键时
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //ToDo 2秒之内连续点击两次
            // 退出程序，如果第二次点击超过2秒了，提示“再按一次退出程序”
            //原始为false先按一下时为true，执行吐丝的方法
            // 2秒内再按一下因为if的原因true变为false，走else的方法，退出
            //2秒外再按一次handler把true变为false，false因为if变成true，吐丝
            if (!mIsExit) {//原本为false因为if判断得到true
                mIsExit = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //handler延迟发送，2秒之后把变量值改为true

                //使用自定义的定时线程池
                ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
                        .executeTimerTask(new Runnable() {
                            @Override
                            public void run() {
                                mIsExit = false;
                            }
                        }, 2000, TimeUnit.SECONDS);
            } else {
                //ToDo 退出
                ContainManager.getmManager().clearActivity();
            }
            return false;//事件分发
        }
        return super.onKeyDown(keyCode, event);
    }

}