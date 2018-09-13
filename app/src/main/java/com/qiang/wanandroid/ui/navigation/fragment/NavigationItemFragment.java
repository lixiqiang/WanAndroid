package com.qiang.wanandroid.ui.navigation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BasePresenter;

/**
 * @author lixiqiang
 * @data：2018/9/13 0013
 */
public class NavigationItemFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.navigation_item_fragment;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public static Fragment newInstance(String string) {
        NavigationItemFragment fragment = new NavigationItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("parm", string);
        fragment.setArguments(bundle);
        return fragment;
    }
}
