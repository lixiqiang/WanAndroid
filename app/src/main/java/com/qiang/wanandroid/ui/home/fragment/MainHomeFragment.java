package com.qiang.wanandroid.ui.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.ui.home.adapter.HomeArticleAdapter;
import com.qiang.wanandroid.ui.home.presenter.MainHomeFragmentPresenter;
import com.qiang.wanandroid.ui.home.view.MainHomeFragmentView;

import butterknife.BindView;

/**
 * @auther lixiqiang
 * @data：2018/8/31 0031
 */
public class MainHomeFragment extends BaseFragment<MainHomeFragmentPresenter> implements MainHomeFragmentView {


    private static final String ARG_PARAM = "param";
    private static final String ARG_PARAM2 = "param2";


//    @BindView(R.id.common_toolbar)
//    Toolbar commonToolbar;

    @BindView(R.id.home_recycler_view)
    RecyclerView homeRecyclerView;
//    @BindView(R.id.tv_toolbar_title)
//    TextView tvToolbarTitle;


    private String mParam;


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

    }

    @Override
    protected void initData() {
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        homeRecyclerView.setAdapter(new HomeArticleAdapter(getContext()));
    }

    public static MainHomeFragment newInstance(String param) {
        MainHomeFragment fragment = new MainHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

}
