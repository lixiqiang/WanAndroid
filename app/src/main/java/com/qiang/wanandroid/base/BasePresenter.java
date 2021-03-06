package com.qiang.wanandroid.base;


import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter <T extends BaseView> {

    public T mView;

    private CompositeDisposable compositeDisposable;


    public void attachView(T view) {
        this.mView = view;
    }


    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            Log.e("detachView", "detachView");
        }
    }


    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }


}
