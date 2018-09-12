package com.qiang.wanandroid.ui.system.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseActivity;
import com.qiang.wanandroid.base.BaseFragmentStateAdapter;
import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.ui.system.fragment.SystemChildListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lixiqiang
 * @data：2018/9/10 0010
 */
public class SystemChildActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.system_tab)
    TabLayout systemTab;
    @BindView(R.id.system_view_pager)
    ViewPager systemViewPager;


    String title;
    ArrayList<String> titleList;
    ArrayList<Integer> idList;
    List<Fragment> fragmentList;
    BaseFragmentStateAdapter pagerAdapter;


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_system_child;
    }

    @Override
    public void initView() {

        if (getIntent() != null) {
            titleList = getIntent().getStringArrayListExtra("titleList");
            idList = getIntent().getIntegerArrayListExtra("childId");
            title = getIntent().getStringExtra("title");
        }

        tvTitle.setText(title);

        fragmentList = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            TabLayout.Tab tab = systemTab.newTab();
            tab.setText(titleList.get(i));
            systemTab.addTab(tab);
        }
        for (int i = 0; i < titleList.size(); i++) {
            SystemChildListFragment fragment = (SystemChildListFragment) SystemChildListFragment.newInstance(idList.get(i));
            fragmentList.add(fragment);

        }

        pagerAdapter = new BaseFragmentStateAdapter(getSupportFragmentManager(), fragmentList);
        pagerAdapter.setTitleList(titleList);

        systemViewPager.setAdapter(pagerAdapter);
        systemTab.setupWithViewPager(systemViewPager);

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
