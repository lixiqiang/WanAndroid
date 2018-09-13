package com.qiang.wanandroid.ui.navigation.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseFragmentPagerAdapter;
import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.ui.navigation.adapter.NavigationTitleAdapter;
import com.qiang.wanandroid.widget.DefaultTransformer;
import com.qiang.wanandroid.widget.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lixiqiang
 * @data：2018/9/13 0013
 */
public class NavigationFragment extends BaseFragment {


    @BindView(R.id.navigation_recycler_view)
    RecyclerView navigationRecyclerView;
    @BindView(R.id.navigation_view_pager)
    VerticalViewPager navigationViewPager;

    List<String> titles;
    NavigationTitleAdapter adapter;

    List<Fragment> fragmentList;


    @Override
    public int getLayoutId() {
        return R.layout.navigation_fragment;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        titles = new ArrayList<>();
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titles.add("标题");
            fragmentList.add(NavigationItemFragment.newInstance(""));
        }

        adapter = new NavigationTitleAdapter(titles);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        navigationRecyclerView.setLayoutManager(manager);
        navigationRecyclerView.setAdapter(adapter);

        navigationViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        navigationViewPager.setPageTransformer(true,new DefaultTransformer());

        navigationViewPager.setAdapter(new BaseFragmentPagerAdapter(getChildFragmentManager(), fragmentList));

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                navigationViewPager.setCurrentItem(position);
            }
        });
        navigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationRecyclerView.scrollToPosition(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    public static NavigationFragment newInstance(String parm) {
        NavigationFragment fragment = new NavigationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Parm", parm);
        fragment.setArguments(bundle);
        return fragment;
    }

}
