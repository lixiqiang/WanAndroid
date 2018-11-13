package com.qiang.wanandroid.ui.project.presenter;

import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.http.Api;
import com.qiang.wanandroid.http.RetrofitManager;
import com.qiang.wanandroid.ui.project.model.ProjectItemBean;
import com.qiang.wanandroid.ui.project.view.ProjectView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lixiqiang
 * @data：2018/11/5 0005
 */
public class ProjectPresenter extends BasePresenter<ProjectView> {


    public void getProject() {

        RetrofitManager.getInstance().createReq(Api.class).getProject()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<List<ProjectItemBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<List<ProjectItemBean>> listBaseResponse) {
                        mView.getProjectSuccess(listBaseResponse);

                    }

                    @Override
                    public void onError(Throwable e) {

                        mView.getProjectFail();

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
