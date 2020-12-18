package com.example.base;




import com.example.IBase.IBaseModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 项目名:TongPao
 * 包名:com.example.mylibrary.Base
 * 创建者: WangTQ
 * 创建时间: 2020/11/24
 */
public abstract class BaseModel implements IBaseModel {
    CompositeDisposable disposableset = new CompositeDisposable();

    @Override
    public void addDisposable(Disposable disposable) {
        this.disposableset.add(disposable);
    }

    @Override
    public void clear() {
        disposableset.clear();
    }
}
