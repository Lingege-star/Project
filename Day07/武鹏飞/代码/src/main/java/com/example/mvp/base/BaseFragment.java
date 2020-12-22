package com.example.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

//fragment的基类
//通过泛型与P层关联
public abstract class BaseFragment<P extends  BasePresenter,T> extends Fragment implements IBaseView<T> {

    private Unbinder mBind;
    private P mPresenter;//引用变量得到P层对象

    @Nullable
    @Override//fragment视图创建的方法，加载控件
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建加载的布局，抽象方法
         int layoutId = getLayoutId();
         View view = null;
         if (layoutId!=0){
             //加载布局
             view = inflater.inflate(layoutId, null);
             //绑定ButterKnife，找控件
             mBind = ButterKnife.bind(this, view);
         }
         //创建P层对象，抽象的
        mPresenter = createPresenter();
         //调用P层的方法关联V层
         if (mPresenter!=null){
             mPresenter.attachView(this);
         }
        return view;
    }
    //不知道具体的P层，抽象的P层对象
    protected abstract P createPresenter();
    //在继承的fragment中可以掉用P层的方法
    protected P getmPresenter(){
        if (mPresenter!=null){
            return mPresenter;
        }
        return null;
    }

    @Override//不是生命周期的方法，在onCreateView后执行
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();//初始化布局
        initData();//初始化数据
    }
    //初始化数据
    protected void initData(){
    }
    //初始化布局
    protected abstract void init();

    //加载布局的方法，抽象
    protected abstract int getLayoutId();

    @Override//访问网络成功
    public void onSuccess(T t) {
    }

    @Override//访问网络失败
    public void onError(String msg) {
    }

    @Override//fragment视图销毁的方法，销毁view
    public void onDestroyView() {
        super.onDestroyView();
        //注销ButterKnife
        if (mBind!=null){
            mBind.unbind();
        }
        //断开网络请求
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
