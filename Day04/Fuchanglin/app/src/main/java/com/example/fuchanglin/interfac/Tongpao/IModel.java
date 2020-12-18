package com.example.fuchanglin.interfac.Tongpao;

import io.reactivex.disposables.Disposable;

public interface IModel {
    void addDisposable(Disposable disposable);

    void clear();
}
