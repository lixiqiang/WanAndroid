package com.qiang.wanandroid.ui.system.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.fragment.MainHomeFragment;
import com.qiang.wanandroid.ui.system.activity.SystemChildActivity;
import com.qiang.wanandroid.ui.system.adapter.SystemListAdapter;
import com.qiang.wanandroid.ui.system.model.SystemChildren;
import com.qiang.wanandroid.ui.system.presenter.SystemFragmentPresenter;
import com.qiang.wanandroid.ui.system.view.SystemFragmentView;
import com.qiang.wanandroid.utils.ActivityJumpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author lixiqiang
 * @data：2018/9/10 0010
 */
public class SystemFragment extends BaseFragment<SystemFragmentPresenter> implements SystemFragmentView {

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

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                SystemChildren tree = systemChildrenList.get(position);
                ArrayList<String> titleList = new ArrayList<>();
                ArrayList<Integer> idList = new ArrayList<>();
                for (int i = 0; i < tree.getChildren().size(); i++) {
                    titleList.add(tree.getChildren().get(i).getName());
                    idList.add(tree.getChildren().get(i).getId());
                }

                Intent intent = new Intent();
                intent.setClass(getActivity(), SystemChildActivity.class);
                intent.putStringArrayListExtra("titleList", titleList);
                intent.putIntegerArrayListExtra("childId", idList);
                intent.putExtra("title", tree.getName());
                startActivity(intent);

            }
        });

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
