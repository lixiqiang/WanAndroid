package com.qiang.wanandroid.ui.navigation.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseFragment;
import com.qiang.wanandroid.base.BasePresenter;
import com.qiang.wanandroid.ui.main.activity.ArticleActivity;
import com.qiang.wanandroid.ui.navigation.adapter.NavigationItemAdapter;
import com.qiang.wanandroid.ui.navigation.adapter.NavigationTitleAdapter;
import com.qiang.wanandroid.ui.navigation.model.Articles;
import com.qiang.wanandroid.widget.FlowLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lixiqiang
 * @data：2018/9/13 0013
 */
public class NavigationItemFragment extends BaseFragment {

    Articles articles;

    NavigationItemAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            articles = (Articles) getArguments().getSerializable("parm");
        }
    }

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

        recyclerView.setNestedScrollingEnabled(false);

        List<String> content = new ArrayList<>();

        for (Articles.ArticlesBean bean : articles.getArticles()) {
            content.add(bean.getTitle());
        }

        adapter = new NavigationItemAdapter(content);

        FlowLayoutManager manager = new FlowLayoutManager();
        recyclerView.addItemDecoration(new Decoration(20));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                ArticleActivity.startArticleActivity(getActivity(), articles.getArticles().get(position).getTitle(),
                        articles.getArticles().get(position).getLink());
            }
        });


    }

    @Override
    protected void initData() {

    }

    public static Fragment newInstance(Articles articles) {

        NavigationItemFragment fragment = new NavigationItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("parm", articles);
        fragment.setArguments(bundle);
        return fragment;
    }


    public class Decoration extends RecyclerView.ItemDecoration {

        private int mDividerHeight;

        public Decoration(int mDividerHeight) {
            this.mDividerHeight = mDividerHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(mDividerHeight, mDividerHeight, 0, 0);
        }
    }


}
