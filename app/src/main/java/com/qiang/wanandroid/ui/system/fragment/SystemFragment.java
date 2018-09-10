package com.qiang.wanandroid.ui.system.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.fragment.MainHomeFragment;
import com.qiang.wanandroid.ui.system.adapter.SystemListAdapter;
import com.qiang.wanandroid.ui.system.model.SystemChildren;
import com.qiang.wanandroid.ui.system.presenter.SystemFragmentPresenter;
import com.qiang.wanandroid.ui.system.view.SystemFragmentView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author lixiqiang
 * @data：2018/9/10 0010
 */
public class SystemFragment extends BaseFragment <SystemFragmentPresenter>implements SystemFragmentView  {

    private static final String ARG_PARAM = "param";

    @BindView(R.id.system_recycler_view)
    RecyclerView systemRecyclerView;
    @BindView(R.id.system_refresh_layout)
    SmartRefreshLayout systemRefreshLayout;

    List<SystemChildren> systemChildrenList;
    SystemListAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.main_system_fragment;
    }

    @Override
    public SystemFragmentPresenter initPresenter() {
        return new SystemFragmentPresenter();
    }

    @Override
    protected void initView() {
        systemChildrenList = new ArrayList<>();
        adapter = new SystemListAdapter(systemChildrenList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        systemRecyclerView.setLayoutManager(layoutManager);
        systemRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getSystemList();

    }


    @Override
    public void getSystemListSuccess(BaseResponse<List<SystemChildren>> listBaseResponse) {
        adapter.addData(listBaseResponse.getData());
    }

    @Override
    public void getSystemListFail() {

    }

    public static SystemFragment newInstance(String param) {
        SystemFragment fragment = new SystemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }
}
