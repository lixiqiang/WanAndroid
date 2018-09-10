package com.qiang.wanandroid.ui.system.presenter;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.http.Api;
import com.qiang.wanandroid.http.RetrofitManager;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;
import com.qiang.wanandroid.ui.system.model.SystemChildren;
import com.qiang.wanandroid.ui.system.view.SystemFragmentView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lixiqiang
 * @data：2018/9/10 0010
 */
public class SystemFragmentPresenter extends BasePresenter<SystemFragmentView>{


    public void getSystemList() {

        RetrofitManager.getInstance().createReq(Api.class)
                .getSystemList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<List<SystemChildren>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscribe(d);
                    }

                    @Override
                    public void onNext(BaseResponse<List<SystemChildren>> listBaseResponse) {
                        mView.getSystemListSuccess(listBaseResponse);

                    }


                    @Override
                    public void onError(Throwable e) {
                        mView.getSystemListFail();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
