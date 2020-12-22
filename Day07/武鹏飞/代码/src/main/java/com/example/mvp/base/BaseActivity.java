package com.example.mvp.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

//所有Activity都可以继承的类，activity的基类
//需要实现网络数据的时候继承IBaseView接口
//activity的公有事件：创建view，点击事件
//通过泛型V层关联P层
public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder mBind;
    private P mPresenter;//变量引用，得到P层对象

    //activity创建的方法，加载布局，初始化控件
    //在父类中将方法写好，子类直接继承父类，重写方法就可以了
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity加载布局，抽象方法，具体加载布局由子View决定
        int layoutId = getLayoutId();
        //在调用后重写方法时会默认返回值是一个0，要进行非空判断
        if (layoutId!=0){
            //根据布局id进行判断，加载布局
            setContentView(layoutId);
        }
        //绑定ButterKnife，进行加载控件，父类中绑定一次就可以了，子类会自动调用
        mBind = ButterKnife.bind(this);
        //将继承这个基类的Activity添加到集合里面
       ContainManager.getmManager().addActivity(this);

        //1.创建P层对象并且关联V层 P对象是抽象的
       mPresenter = createPresenter();
       if (mPresenter != null){
           //P层基类中关联V层的方法
            mPresenter.attachView(this);
       }
        init();    //初始化View
        initData(); //初始化数据
    }
    //加载布局的方法，抽象方法，具体是由子布局决定
    protected abstract int getLayoutId();
    //创建P层对象，因为不知道，所以是抽象的
    protected abstract P createPresenter();

    //获取P层对象，在activity中可以调用方法
    //在继承的activity中可以掉用P层的方法
    protected P getmPresenter(){
        if (mPresenter!=null){
            return mPresenter;
        }
        return null;
    }
    //是否是抽象方法根据需要决定，抽象方法需要重写方法
    //初始化数据
    protected void initData() {
    }
    //初始化View
    protected abstract void init();

    //点击事件
//    protected abstract void Click(View view);

    @Override//访问网络成功
    public void onSuccess(T t) {
    }

    @Override//访问网络失败
    public void onError(String msg) {
    }

    @Override//销毁activity，释放资源
    protected void onDestroy() {
        super.onDestroy();
        //解绑ButterKnife
        if (mBind!=null){
            mBind.unbind();
        }
        //P层调用，关闭网络请求
        if(mPresenter!=null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
