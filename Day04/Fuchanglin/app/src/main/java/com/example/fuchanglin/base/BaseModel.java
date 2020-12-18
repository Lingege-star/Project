package com.example.fuchanglin.base;

import com.example.fuchanglin.interfac.Tongpao.IModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel implements IModel {
    CompositeDisposable disposableSet = new CompositeDisposable();

    /**
     * 把当前的网络请求添加到缓存
     * @param disposable
     */
    @Override
    public void addDisposable(Disposable disposable) {
        disposableSet.add(disposable);
    }

    /**
     * 取消还未进行的网络请求
     */
    @Override
    public void clear() {
        disposableSet.clear();
    }
}
