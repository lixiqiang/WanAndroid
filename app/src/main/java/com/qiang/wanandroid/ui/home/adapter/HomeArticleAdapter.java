package com.qiang.wanandroid.ui.home.adapter;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qiang.wanandroid.R;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;

import java.util.List;


/**
 * @auther lixiqiang
 * @data：2018/9/1 0001
 */
public class HomeArticleAdapter extends BaseQuickAdapter<ArticleListBean.DatasBean,BaseViewHolder> {


    public HomeArticleAdapter(@Nullable List<ArticleListBean.DatasBean> data) {
        super(R.layout.item_home_article, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleListBean.DatasBean item) {
        helper.setText(R.id.tv_nickname, item.getAuthor());
        helper.setText(R.id.tv_chapter_name, item.getSuperChapterName() + "/" + item.getChapterName());
        helper.setText(R.id.tv_article_title, item.getTitle());
        helper.setText(R.id.tv_time, item.getNiceDate());
    }
}
