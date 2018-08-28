package com.qiang.wanandroid.http;

import com.qiang.wanandroid.app.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static RetrofitManager instance;

    private static Retrofit retrofit;

    private RetrofitManager() {
        initRetrofit();

    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                // 返回Call替换为Observable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                // 返回数据类型默认ResponseBody, 添加Gson支持
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance() {
        if (instance == null) {
            instance = new RetrofitManager();
        }
        return instance;
    }

    public <T> T createReq(Class<T> reqServer) {
        return retrofit.create(reqServer);
    }
}
