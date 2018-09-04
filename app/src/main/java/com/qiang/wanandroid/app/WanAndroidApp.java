package com.qiang.wanandroid.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;


public class WanAndroidApp extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        LeakCanary.install(this);

    }

    public static Context getContext() {
        return mContext;
    }
}
