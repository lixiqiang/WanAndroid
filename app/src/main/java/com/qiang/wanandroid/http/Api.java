package com.qiang.wanandroid.http;

import com.qiang.wanandroid.base.BaseResponse;
import com.qiang.wanandroid.ui.home.model.ArticleListBean;
import com.qiang.wanandroid.ui.system.model.SystemChildList;
import com.qiang.wanandroid.ui.system.model.SystemChildren;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author lixiqiang
 * @data：2018/9/4 0004
 */
public interface Api {

    @GET("/article/list/{page}/json")
    Observable<BaseResponse<ArticleListBean>> getHomeArticleList(@Path("page") int page);

    @GET("/tree/json")
    Observable<BaseResponse<List<SystemChildren>>> getSystemList();


    //    http://www.wanandroid.com/article/list/0/json?cid=60
    @GET("/article/list/{page}/json")
    Observable<BaseResponse<SystemChildList>> getSystemArticleList(@Path("page") int page,
                                                                   @Query("cid") int id);


}
