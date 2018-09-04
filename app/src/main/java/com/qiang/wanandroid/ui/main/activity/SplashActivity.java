package com.qiang.wanandroid.ui.main.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseActivity;
import com.qiang.wanandroid.ui.main.presenter.SplashPresenter;
import com.qiang.wanandroid.ui.main.view.SplashView;
import com.qiang.wanandroid.utils.ActivityJumpUtils;

import butterknife.BindView;

/**
 * @auther lixiqiang
 * @data：2018/8/29 0029
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView {

    @BindView(R.id.tv_jump_time)
    TextView tvJumpTime;
    @BindView(R.id.iv_splash_cover)
    ImageView ivSplashCover;

    @Override
    protected SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mPresenter.splashStart();

    }

    @Override
    public void initData() {

    }

    @Override
    public void updateTime(long second) {

        tvJumpTime.setText(second + "后跳转");
    }

    @Override
    public void jumpToMain() {
        ActivityJumpUtils.startActivity(this, MainActivity.class, true);

    }

}
