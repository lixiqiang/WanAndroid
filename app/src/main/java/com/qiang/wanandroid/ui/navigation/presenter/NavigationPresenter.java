package com.qiang.wanandroid.ui.navigation.presenter;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.http.Api;
import com.qiang.wanandroid.http.RetrofitManager;
import com.qiang.wanandroid.ui.navigation.model.Articles;
import com.qiang.wanandroid.ui.navigation.view.NavigationView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lixiqiang
 * @data：2018/9/28 0028
 */
public class NavigationPresenter extends BasePresenter<NavigationView> {


    public void getNavigation() {
        RetrofitManager.getInstance().createReq(Api.class)
                .getNavigation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<List<Articles>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<List<Articles>> listBaseResponse) {
                        mView.getNavigationSuccess(listBaseResponse);

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
