package com.example.day15.map.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day15.R;
import com.example.day15.Util.StatusBarUtil;
import com.example.day15.map.Manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.internal.operators.single.SingleTakeUntil;


public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T> {
    private Unbinder mBind;
    private P mPresenter;
//
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.colorWithe);
        //Activity加载布局
        int layoutId=getlayoutId();
        if(layoutId!=0)
            //设置加载布局
            setContentView(layoutId);
        //黄油刀绑定上下文
        mBind= ButterKnife.bind(this);
        //将所有的Activity添加到集合里面
        ContainManager.getManager().addActivity(this);
        //1.创建P层对象并且关联V层
        mPresenter=createPresenter();
        if(mPresenter!=null)
            //P层依附视图
            mPresenter.attachView(this);
        //初始化view
        init();
        //初始化数据
        initData();
    }

    protected abstract P createPresenter();
    //获取P层对象
    protected P getmPresenter(){
        if(mPresenter!=null){
            return mPresenter;
        }
        return null;
    }

    protected void initData() {

    }

    protected abstract void init();
    protected abstract void click(View view);
    protected abstract int getlayoutId();

    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }
//释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBind!=null){
            mBind.unbind();
        }
        if(mPresenter!=null){
            mPresenter.detachView();
            mPresenter=null;
        }
    }
}
