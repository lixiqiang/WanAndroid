package com.qiang.wanandroid.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
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
import butterknife.OnClick;

/**
 * @author lixiqiang
 * @data：2018/9/7 0007
 */
public class ArticleActivity extends BaseActivity {

    private static final String ARTICLE_TITLE = "article_title";
    private static final String ARTICLE_URL = "article_url";


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_article_title)
    TextView tvArticleTitle;
    @BindView(R.id.article_web_view)
    FrameLayout articleWebView;

    private AgentWeb agentWeb;
    private String articleUrl;
    private String articleTitle;

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

        if (getIntent() != null) {
            articleTitle = getIntent().getStringExtra(ARTICLE_TITLE);
            articleUrl = getIntent().getStringExtra(ARTICLE_URL);
        }
        tvArticleTitle.setText(articleTitle);

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
            default:
                break;
        }
    }


    public static void startArticleActivity(Activity context, String title, String articleUrl) {

        Intent intent = new Intent();
        intent.putExtra(ARTICLE_TITLE, title);
        intent.putExtra(ARTICLE_URL, articleUrl);
        intent.setClass(context, ArticleActivity.class);
        context.startActivity(intent);
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
