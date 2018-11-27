package com.qiang.wanandroid.ui.system.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.adapter.ArticleItemAdapter;
import com.qiang.wanandroid.ui.home.model.ArticleBean;
import com.qiang.wanandroid.ui.main.activity.ArticleActivity;
import com.qiang.wanandroid.ui.system.model.SystemChildList;
import com.qiang.wanandroid.ui.system.presenter.SystemChildListPresenter;
import com.qiang.wanandroid.ui.system.view.SystemChildListFragmentView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author lixiqiango
 * @data：2018/9/11 0011
 */
public class SystemChildListFragment extends BaseFragment<SystemChildListPresenter> implements SystemChildListFragmentView {

    public static final String ID = "id";
    @BindView(R.id.system_child_recycler_view)
    RecyclerView systemChildRecyclerView;
    @BindView(R.id.system_child_refresh)
    SmartRefreshLayout systemChildRefresh;

    ArticleItemAdapter articleAdapter;

    List<ArticleBean> list;

    private int id;
    private int page;

    @Override
    public int getLayoutId() {
        return R.layout.system_child_list_fragment;
    }

    @Override
    public SystemChildListPresenter initPresenter() {
        return new SystemChildListPresenter();
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            id = getArguments().getInt(ID);
        }
        list = new ArrayList<>();
        articleAdapter = new ArticleItemAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        systemChildRecyclerView.setLayoutManager(manager);
        systemChildRecyclerView.setAdapter(articleAdapter);


        systemChildRefresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.getSystemChildListArticle(page, id);

            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getSystemChildListArticle(0, id);

            }
        });
        articleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                ArticleBean bean = list.get(position);
                if (bean != null) {
                    ArticleActivity.startArticleActivity(getActivity(), bean.getTitle(), bean.getLink());
                }

            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.getSystemChildListArticle(0, id);

    }

    public static Fragment newInstance(int id) {
        SystemChildListFragment fragment = new SystemChildListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void getSystemChildListSuccess(BaseResponse<SystemChildList> response) {
        if (response.getData().getCurPage() == 1) {
            systemChildRefresh.finishRefresh();
            articleAdapter.replaceData(response.getData().getDatas());
        } else {
            systemChildRefresh.finishLoadMore();
            articleAdapter.addData(response.getData().getDatas());
        }
        page = response.getData().getCurPage();

        if (response.getData().isOver()) {
            systemChildRefresh.setNoMoreData(true);
        }


    }

    @Override
    public void getSystemChildListFail() {

    }
}
