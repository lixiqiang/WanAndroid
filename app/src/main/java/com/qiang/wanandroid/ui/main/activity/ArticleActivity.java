package com.qiang.wanandroid.ui.main.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.base.BaseActivity;
import com.qiang.wanandroid.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @auther lixiqiang
 * @data：2018/9/7 0007
 */
public class ArticleActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_article_title)
    TextView tvArticleTitle;
    @BindView(R.id.article_web_view)
    FrameLayout articleWebView;

    private AgentWeb agentWeb;
    private String articleUrl;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    public void initView() {
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent(articleWebView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(articleUrl);


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
        }
    }
}
