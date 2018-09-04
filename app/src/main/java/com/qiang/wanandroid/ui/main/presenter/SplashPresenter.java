package com.qiang.wanandroid.ui.main.presenter;

import android.util.Log;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.main.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @auther lixiqiang
 * @data：2018/8/29 0029
 */
public class SplashPresenter extends BasePresenter<SplashView> {

    private static final String TAG = "SplashPresenter";


    public void splashStart() {




        Observable.interval(1, TimeUnit.SECONDS)
                .take(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscribe(d);
                        Log.e(TAG, "onSubscribe 3");
                        mView.updateTime(3);

                    }

                    @Override
                    public void onNext(Long aLong) {
                        if (aLong < 2) {
                            Log.e(TAG, aLong + ","+(3 - aLong - 1));
                            mView.updateTime(3 - aLong - 1);
                        } else {
                            mView.updateTime(3 - aLong - 1);
                            Log.e(TAG, aLong + "jump," + (3 - aLong - 1));
                            mView.jumpToMain();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

}
