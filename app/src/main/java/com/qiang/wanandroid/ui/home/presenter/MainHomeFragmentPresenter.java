package com.qiang.wanandroid.ui.home.presenter;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.http.Api;
import com.qiang.wanandroid.http.RetrofitManager;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;
import com.qiang.wanandroid.ui.home.view.MainHomeFragmentView;

import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther lixiqiang
 * @data：2018/8/31 0031
 */
public class MainHomeFragmentPresenter extends BasePresenter<MainHomeFragmentView> {

    public void getHomeArticleList(int page) {

        RetrofitManager.getInstance().createReq(Api.class)
                .getHomeArticleList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<ArticleListBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscribe(d);
                    }

                    @Override
                    public void onNext(BaseResponse<ArticleListBean> response) {

                        mView.getHomeArticleListSuccess(response);

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getHomeArticleListFail();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
