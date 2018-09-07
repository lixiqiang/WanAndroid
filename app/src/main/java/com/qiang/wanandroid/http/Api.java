package com.qiang.wanandroid.http;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @auther lixiqiang
 * @data：2018/9/4 0004
 */
public interface Api {

    @GET("/article/list/{page}/json")
    Observable<BaseResponse<ArticleListBean>> getHomeArticleList(@Path("page") int page);

}
