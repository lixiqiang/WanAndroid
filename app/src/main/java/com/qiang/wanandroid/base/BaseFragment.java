package com.qiang.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment <T extends BasePresenter> extends Fragment implements BaseView {


    private View rootView;
    public T mPresenter;
    public Unbinder unbinder;

    private boolean isVisible;
    private boolean isPrepared;
    private boolean isFirst = true;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoadData();
        } else {
            isVisible = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint()){
            setUserVisibleHint(true);
        }
    }

    public abstract int getLayoutId();

    public abstract T initPresenter();

    protected abstract void initView();

    // 懒加载  第一次可见时加载
    protected abstract void initData();

    public void lazyLoadData() {
        if (isPrepared && isVisible && isFirst) {
            initData();
            isFirst = false;
        } else {
            return;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
