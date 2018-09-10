package com.qiang.wanandroid.ui.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.adapter.HomeArticleAdapter;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;
import com.qiang.wanandroid.ui.home.presenter.MainHomeFragmentPresenter;
import com.qiang.wanandroid.ui.home.view.MainHomeFragmentView;
import com.qiang.wanandroid.ui.main.activity.ArticleActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lixiqiang
 * @data：20018/09/10
 */
public class MainHomeFragment extends BaseFragment<MainHomeFragmentPresenter> implements MainHomeFragmentView {

    private static final String TAG = "MainHomeFragment";
    private static final String ARG_PARAM = "param";
    private static final String ARG_PARAM2 = "param2";


    @BindView(R.id.home_recycler_view)
    RecyclerView homeRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;


    private String mParam;

    private int page;
    private HomeArticleAdapter articleAdapter;
    private List<ArticleListBean.DatasBean> mList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_home_fragment;
    }

    @Override
    public MainHomeFragmentPresenter initPresenter() {
        return new MainHomeFragmentPresenter();
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        articleAdapter = new HomeArticleAdapter(mList);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        homeRecyclerView.setAdapter(articleAdapter);


        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

                mPresenter.getHomeArticleList(page);
            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getHomeArticleList(0);

            }
        });

        articleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ArticleListBean.DatasBean bean = mList.get(position);
                ArticleActivity.startArticleActivity(getActivity(), bean.getTitle(), bean.getLink());

            }
        });

    }

    @Override
    protected void initData() {

        mPresenter.getHomeArticleList(0);
    }

    public static MainHomeFragment newInstance(String param) {
        MainHomeFragment fragment = new MainHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void getHomeArticleListSuccess(BaseResponse<ArticleListBean> bean) {

        if (bean.getData().getCurPage() == 1) {
            refreshLayout.finishRefresh();
            articleAdapter.replaceData(bean.getData().getDatas());

        } else {
            refreshLayout.finishLoadMore();
            articleAdapter.addData(bean.getData().getDatas());

        }
        page = bean.getData().getCurPage();

    }

    @Override
    public void getHomeArticleListFail() {

    }
}
