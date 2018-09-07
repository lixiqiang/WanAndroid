package com.qiang.wanandroid.ui.home.view;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.base.BaseView;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;

/**
 * @auther lixiqiang
 * @data：2018/8/31 0031
 */
public interface MainHomeFragmentView extends BaseView{

    public void getHomeArticleListSuccess(BaseResponse<ArticleListBean> bean);

    public void getHomeArticleListFail();


}
