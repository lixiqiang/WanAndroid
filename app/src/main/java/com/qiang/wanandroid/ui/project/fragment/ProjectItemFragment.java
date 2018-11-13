package com.qiang.wanandroid.ui.project.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.ui.project.presenter.ProjectItemPresenter;
import com.qiang.wanandroid.ui.project.view.ProjectItemView;

/**
 * @author lixiqiang
 * @data：2018/11/5 0005
 */
public class ProjectItemFragment extends BaseFragment<ProjectItemPresenter> implements ProjectItemView {


    public static ProjectItemFragment newInstance(int id) {

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ProjectItemFragment fragment = new ProjectItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.project_item_fragment;
    }

    @Override
    public ProjectItemPresenter initPresenter() {
        return new ProjectItemPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
