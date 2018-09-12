package com.qiang.wanandroid.ui.system.presenter;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.http.Api;
import com.qiang.wanandroid.http.RetrofitManager;
import com.qiang.wanandroid.ui.system.model.SystemChildList;
import com.qiang.wanandroid.ui.system.view.SystemChildListFragmentView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lixiqiang
 * @data：2018/9/12 0012
 */
public class SystemChildListPresenter extends BasePresenter<SystemChildListFragmentView> {


    public void getSystemChildListArticle(int page, int cid) {
        RetrofitManager.getInstance().createReq(Api.class)
                .getSystemArticleList(page, cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<SystemChildList>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addSubscribe(d);
                    }

                    @Override
                    public void onNext(BaseResponse<SystemChildList> response) {
                        mView.getSystemChildListSuccess(response);


                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.getSystemChildListFail();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
