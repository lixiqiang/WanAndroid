package com.qiang.wanandroid.ui.project.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseFragmentPagerAdapter;
import com.qiang.wanandroid.base.BaseFragmentStateAdapter;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.project.model.ProjectItemBean;
import com.qiang.wanandroid.ui.project.presenter.ProjectPresenter;
import com.qiang.wanandroid.ui.project.view.ProjectView;
import com.qiang.wanandroid.ui.system.fragment.SystemChildListFragment;
import com.qiang.wanandroid.ui.system.model.SystemChildList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author lixiqiang
 * @data：2018/11/5 0005
 */
public class ProjectFragment extends BaseFragment<ProjectPresenter> implements ProjectView {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    List<Fragment> fragmentList;
    List<String> titleList;

    BaseFragmentStateAdapter adapter;


    public static ProjectFragment newInstance(String param) {
        ProjectFragment fragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param", param);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.project_fragment;
    }

    @Override
    public ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected void initView() {

        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();

    }

    @Override
    protected void initData() {
        mPresenter.getProject();

    }

    @Override
    public void getProjectSuccess(BaseResponse<List<ProjectItemBean>> list) {

        createFragment(list);


    }

    private void createFragment(BaseResponse<List<ProjectItemBean>> list) {



        for (int i = 0; i < list.getData().size(); i++) {

            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(list.getData().get(i).getName());
            titleList.add(list.getData().get(i).getName());
            tabLayout.addTab(tab);

            Fragment fragment = SystemChildListFragment.newInstance(list.getData().get(i).getId());
            fragmentList.add(fragment);
        }

        adapter = new BaseFragmentStateAdapter(getChildFragmentManager(), fragmentList);
        adapter.setTitleList(titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void getProjectFail() {

    }
}
