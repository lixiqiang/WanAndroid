package com.qiang.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {


    public T mPresenter;

    public ImmersionBar immersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        ButterKnife.bind(this);
//        ImmersionBar.with(this).init();
        immersionBar = ImmersionBar.with(this);
        immersionBar.init();

        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        initData();
    }



    protected abstract T initPresenter();

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        Log.e("onDestroy", "onDestroy");
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (immersionBar != null) {
            immersionBar.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
